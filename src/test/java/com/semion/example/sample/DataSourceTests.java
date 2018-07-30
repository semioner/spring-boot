package com.semion.example.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by heshuanxu on 2018/7/30.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTests {

    @Autowired
    ApplicationContext applicationContext;


    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);


        PlatformTransactionManager bean = applicationContext.getBean(PlatformTransactionManager.class);


        log.info(dataSource.toString());


    }


}
