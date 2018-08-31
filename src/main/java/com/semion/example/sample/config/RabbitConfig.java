package com.semion.example.sample.config;

import com.semion.example.sample.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {
    @Bean
    public Queue initQ() {
        log.info("初始化队列：{}", Constant.queueName);
        return new Queue(Constant.queueName);
    }

}
