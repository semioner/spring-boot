package com.semon.example.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者测试类
 */
@Slf4j
public class ProducerApp {

    @Test
    public void produce() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
//      获取信道
        Channel channel = connection.createChannel();
//      声明交换器
        String exchangeName = "shawn-exchange";
        channel.exchangeDeclare(exchangeName,"direct",true);

        String routeKey = "order";
//      发布消息
        for (int i = 0; i <100; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            channel.basicPublish(exchangeName,routeKey,null,"helloworld".getBytes());
        }
        channel.close();
        connection.close();
    }
}
