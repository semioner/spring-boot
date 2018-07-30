package com.semion.example.sample.controller;

import com.semion.example.sample.domain.UserPo;
import com.semion.example.sample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@RestController
public class SampleController {

    public static final String PATH_ROOT = "/";


    @Autowired
    private UserService userService;

    @RequestMapping(PATH_ROOT)
    public String index() {
        log.info("request index method=========");
        return "hello world index";
    }

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public String addUser(UserPo user) {
        int insert = userService.insert(user);
        return "success";
    }


}
