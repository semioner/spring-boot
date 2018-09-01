package com.semion.example.sample;

import com.semion.example.sample.controller.SampleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SampleApplication()).build();
    }

    /**
     * @Author: heshuanxu
     * @Date: 11:25 2018/7/27
     * @Desc: mockmvc 进行测试
     */
    @Test
    public void contextLoads() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/list") // 请求URL
                .accept(MediaType.APPLICATION_JSON))// 数据格式
                .andExpect(MockMvcResultMatchers.status().isOk())// 返回200状态
                .andDo(MockMvcResultHandlers.print())// 打印结果
                .andReturn();
    }

}
