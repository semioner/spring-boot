package com.semion.example.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@Slf4j
public class SampleApplication {

	/**
	 * @Author: heshuanxu
	 * @Date: 11:30 2018/7/27
	 * @Desc:
	 *  run 方法 1. 构造SpringApplication
	 *          2. webEnvironment Boolean类型判断是否为web环境 依据：通过在classpath中查看是否存在WEB_ENVIRONMENT_CLASSES这个数组中所包含的类
	 *          3. initializers 是一个ApplicationContextInitializer类型对象的集合
	 *          4. listeners 是一个ApplicationListener<?>类型对象的集合
	 *          @EnableScheduling 注解用于开启定时任务
	 */


	public static void main(String[] args) {
		log.info("spring boot start ");
		SpringApplication.run(SampleApplication.class, args);
		log.info("spring boot has started ");
	}
}
