package com.semion.example.sample.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@ComponentScan
@MapperScan("com.semion.example.sample.dao.mapper")
public class DataSourceConfig {

    private String url;
    private String driverClassName;
    private String username;
    private String password;

   /* @Bean
    PageHelper getPageHelp(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;

    }*/

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();//创建SqlSessionFactoryBean类
        sqlSessionFactoryBean.setDataSource(dataSource());//设置数据库链接
        //PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/com/example/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
