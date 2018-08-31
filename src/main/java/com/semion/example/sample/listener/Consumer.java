package com.semion.example.sample.listener;

import com.semion.example.sample.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Consumer {

    /**
     * @RabbitHandler 指定消息处理的方法
     */
    //@RabbitHandler
    @RabbitListener(queues = Constant.queueName)
    public void process(String message) {
        log.info("接受到异步MQ消息：{}", message);
    }

}
