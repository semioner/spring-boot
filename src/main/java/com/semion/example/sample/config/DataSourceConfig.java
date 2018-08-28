package com.semion.example.sample.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Slf4j
public class DataSourceConfig {

    @Setter
    private String url;
    @Setter
    private String driverClassName;
    @Setter
    private String username;
    @Setter
    private String password;

    @Bean
    public DataSource dataSource() {
        log.info("============== dataSource init ===========");
        log.info(url);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    //@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
