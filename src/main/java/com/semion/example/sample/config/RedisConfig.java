package com.semion.example.sample.config;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    @Setter
    private String hosts;

    @Setter
    private int port;
}
