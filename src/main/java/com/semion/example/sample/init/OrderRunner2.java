package com.semion.example.sample.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Slf4j
@Component
@Order(2)
public class OrderRunner2 implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        log.info(this.getClass().getSimpleName() + "start to initialize");
    }
}
