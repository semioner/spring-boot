package com.semion.example.sample.annotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semion.example.sample.domain.SysLog;
import com.semion.example.sample.service.LogService;
import com.semion.example.sample.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;

    @Autowired
    private ObjectMapper mapper;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.semion.example.sample.annotation.Log)")
    public void pointCut(){}


    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint point){
        Object object = null;
        long start = System.currentTimeMillis();
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            log.error("执行目标方法异常：{}",throwable);
        }
        long time = System.currentTimeMillis()-start;
        if(true){
            // 保存日志
            saveLog(point,time);
        }
        return object;
    }

    /**
     * 保存日志信息
     * @param point
     * @param time
     */
    private void saveLog(ProceedingJoinPoint point, long time) {
        try {
            MethodSignature signature = (MethodSignature)point.getSignature();
            Method method =  signature.getMethod();
            SysLog log = new SysLog();
            //方法名
            String name = method.getName();
            log.setMethod(name);
            // 注解的描述
            Log annotation = method.getAnnotation(Log.class);
            if(annotation!=null){
                log.setOperation(annotation.value());
            }
            //请求方法参数值
            Object[] args = point.getArgs();
            LocalVariableTableParameterNameDiscoverer lvtpnd = new LocalVariableTableParameterNameDiscoverer();
            // 获取参数名
            String[] parameterNames = lvtpnd.getParameterNames(method);
            if(args!=null){
                StringBuffer stringBuffer = new StringBuffer();
                int i=0;
                while (i< args.length){
                    stringBuffer.append(parameterNames[i]).append(":").append(this.mapper.writeValueAsString(args[i]));
                    i++;
                }
                log.setParams(stringBuffer.toString());
            }
            log.setCreateTime(new Date());
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            log.setIp(IPUtil.getIpAddr(request));
            log.setTime(time);
            log.setLocation(IPUtil.getRealAddressByIP(log.getIp(),mapper));
            logService.saveLog(log);
        } catch (JsonProcessingException e) {
            log.error("记录日志异常：{}",e);
        }
    }

}
