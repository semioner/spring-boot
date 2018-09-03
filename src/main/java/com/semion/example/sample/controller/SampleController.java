package com.semion.example.sample.controller;

import com.alibaba.fastjson.JSON;
import com.semion.example.sample.annotation.Log;
import com.semion.example.sample.domain.UserPo;
import com.semion.example.sample.service.UserService;
import com.semion.example.sample.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@RestController
public class SampleController {

    public static final String PATH_ROOT = "/";

    @Autowired
    AmqpTemplate rabbitmqTemplate;


    @Autowired
    private UserService userService;

    @Log("访问首页面")
    @RequestMapping(PATH_ROOT)
    public String index() {
        log.info("=========visit index method start======");
        rabbitmqTemplate.convertAndSend("index page");
        return "hello world index page";
    }

    @Log("新增用户")
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addUser(UserPo user) {
        Date date = new Date();
        log.info(date.toString());
        user.setCreatedTime(date);
        String res = userService.insert(user);
        if(res!=null && res.equals("success")){
            log.info("发送异步消息：{}",JSON.toJSONString(user));
            //发送MQ
            rabbitmqTemplate.convertAndSend(Constant.exchangeName,"",JSON.toJSONString(user));
        }
        return "success";
    }

    @Log("查询用户列表")
    @RequestMapping(value = "/list")
    public List<UserPo> selectAll(UserPo user) {
        log.info("查询用户列表start");
        List<UserPo> list = userService.selectAll(user);
        return list;
    }

    /**
     * 异常测试
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/demo")
    public String demo(UserPo user) throws Exception {
//        log.info("dkfjdkfjdkfjk");
        throw new Exception("访问异常");
    }


}
