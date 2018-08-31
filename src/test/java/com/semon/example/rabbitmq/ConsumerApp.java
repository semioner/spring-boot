package com.semon.example.rabbitmq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ConsumerApp {

    @Test
    public void consume() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
//      获取信道
        Channel channel = connection.createChannel();
        //声明交换器
        String exchangeName = "shawn-exchange";
        channel.exchangeDeclare(exchangeName, "direct", true);

//       声明队列
        String queueName = channel.queueDeclare().getQueue();
        String routeKey = "order";
//      通过路由key 将队列和交换器绑定
        channel.queueBind(queueName, exchangeName, routeKey);
        while (true) {
            channel.basicConsume(queueName, false, "", new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //super.handleDelivery(consumerTag, envelope, properties, body);
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();
                    log.info("routingKey:{}, contentType:{}", routingKey, contentType);
                    long deliveryTag = envelope.getDeliveryTag();
                    // 确认消息
                    channel.basicAck(deliveryTag, false);
                    String msg = new String(body, "UTF-8");
                    log.info("消息内容：{}", msg);
                }
            });
        }


    }
}
