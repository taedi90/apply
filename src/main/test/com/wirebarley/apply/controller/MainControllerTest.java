package com.wirebarley.apply.controller;

import com.wirebarley.apply.config.RootConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class MainControllerTest {

    @Inject
    private WebApplicationContext wac;

    private MockMvc mockmvc;

    @Before
    public void setup() {

        log.info("mockMvc 세팅");

        this.mockmvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getIndex() throws Exception {

        log.info("getIndex()");

        this.mockmvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk()) //통신 상태 확인
                .andExpect(handler().handlerType(MainController.class)) //controller 확인
                .andExpect(handler().methodName("getIndex")); //method 확인
    }

    @Test
    public void getExchangeRate() throws Exception {

        log.info("getExchangeRate()");

        this.mockmvc.perform(get("/exchange-rate"))
                .andDo(print())
                .andExpect(status().isOk()) //통신 상태 확인
                .andExpect(handler().handlerType(MainController.class)) //controller 확인
                .andExpect(handler().methodName("getExchangeRate")); //method 확인
    }
}