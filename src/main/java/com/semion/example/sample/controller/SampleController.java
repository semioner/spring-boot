package com.semion.example.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@RestController
public class SampleController {

    public static final String PATH_ROOT = "/";

    @RequestMapping(PATH_ROOT)
    public String index(){
        log.info("request index method=====");
        return "hello world index";
    }


}
