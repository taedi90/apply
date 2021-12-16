package com.wirebarley.apply.service;

import com.wirebarley.apply.config.RootConfig;
import com.wirebarley.apply.dto.ApiResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class MainServiceTest {

    @Setter(onMethod_ = @Autowired)
    private MainService mainService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getExchangeRate() {
        ApiResponse apiResponse = mainService.getExchangeRate();
        log.info(apiResponse.toString());
        assertNotNull(apiResponse);
    }
}