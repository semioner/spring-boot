package com.semion.example.sample.listener;

import com.semion.example.sample.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer2 {

    @RabbitListener(queues = Constant.queueName)
    public void process(String message) {
        log.info("Consumer2 接受到异步MQ消息：{}", message);
    }
}
