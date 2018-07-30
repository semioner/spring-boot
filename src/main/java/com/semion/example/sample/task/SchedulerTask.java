package com.semion.example.sample.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@Component
public class SchedulerTask {


    @Value("${openSwitch}")
    private String openSwitch;

    /**
     * @Author: heshuanxu
     * @Date: 13:48 2018/7/27
     * @Desc: 每分钟一次
     */
    @Scheduled(cron = "0 0/5 * * * ? ")
    private void doTask() {
        if (openSwitch.equals("open")) {
            log.info("task is running.....。。。。");
        }
    }

}
