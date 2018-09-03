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
    @RabbitListener(queues = "fanout.A")
    public void processA(String message) {
        log.info("A接受到MQ消息：{}", message);
    }

    @RabbitListener(queues = "fanout.B")
    public void processB(String message) {
        log.info("B接受到MQ消息：{}", message);
    }

    @RabbitListener(queues = "fanout.C")
    public void processC(String message) {
        log.info("C接受到MQ消息：{}", message);
    }
    @RabbitListener(queues = "fanout.C")
    public void processC_1(String message) {
        log.info("C-1接受到MQ消息：{}", message);
    }

}
