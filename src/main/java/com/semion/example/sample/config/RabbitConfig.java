package com.semion.example.sample.config;

import com.semion.example.sample.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {
    @Bean
    public Queue initQ() {
        return new Queue(Constant.queueName);
    }

    /**
     * 使用fanout类型的交换器
     * @return
     */
    @Bean(name = "Amessage")
    public Queue Amessage(){
        return new Queue("fanout.A");
    }
    @Bean(name = "Bmessage")
    public Queue Bmessage(){
        return new Queue("fanout.B");
    }
    @Bean(name = "Cmessage")
    public Queue Cmessage(){
        return new Queue("fanout.C");
    }


    @Bean
    Exchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }


    @Bean
    Binding bindingExchangeA(Queue Amessage,FanoutExchange fanoutExchange){
       return BindingBuilder.bind(Amessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue Bmessage,FanoutExchange fanoutExchange){
       return BindingBuilder.bind(Bmessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue Cmessage,FanoutExchange fanoutExchange){
       return BindingBuilder.bind(Cmessage).to(fanoutExchange);
    }
}
