package com.semion.example.sample.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by heshuanxu on 2018/7/27.
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /** 
     * @Author: heshuanxu 
     * @Date: 14:42 2018/7/27 
     * @Desc: 上传异常处理
     */
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }
}
