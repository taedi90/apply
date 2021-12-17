package com.wirebarley.apply.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class JasyptConfigTest {

    @Autowired
    private JasyptConfig jasyptConfig;

    @Resource
    private Environment env;

    List<String> arr = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        // 암호화 할 값 입력
        arr.add("password");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stringEncryptor() {

        log.info("stringEncryptor()");

        StringEncryptor encryptor = jasyptConfig.stringEncryptor(env);

        String enc = null; //인코딩 된 문자열
        String dec = null; //디코딩 된 문자열

        for(String plain : arr){
            enc = encryptor.encrypt(plain);
            dec = encryptor.decrypt(enc);

            log.info("enc -> " + enc);
            log.info("dec -> " + dec);

            assertEquals(plain, dec); //문자열 일치여부 확인
        }
    }
}