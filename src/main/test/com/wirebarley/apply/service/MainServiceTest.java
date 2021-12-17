package com.wirebarley.apply.service;

import com.wirebarley.apply.config.RootConfig;
import com.wirebarley.apply.dto.ApiResult;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class MainServiceTest {

    @Setter(onMethod_ = @Autowired)
    private MainService mainService;

    @Test
    public void getExchangeRate() {
        //환율 정보 조회
        ApiResult apiResult = mainService.getExchangeRate();

        //로그 기록
        log.info("getExchangeRate()");
        log.info(apiResult.toString());

        //API 결과 확인
        assertNotNull(apiResult);
    }
}