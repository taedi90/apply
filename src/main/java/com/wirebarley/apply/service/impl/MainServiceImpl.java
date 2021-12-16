package com.wirebarley.apply.service.impl;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.wirebarley.apply.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.wirebarley.apply.service.MainService;

import java.net.URI;

@Service
@EncryptablePropertySource(name = "api", value = "classpath:/api.properties")
public class MainServiceImpl implements MainService {

    @Value("${currencylayer.url}")
    String baseUrl; //환율 API 기본 경로

    @Value("${currencylayer.key}")
    String encKey; //API key

    public ApiResponse getExchangeRate() {

        //URL 설정
        URI targetUrl = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("access_key", encKey)
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        ApiResponse response = restTemplate.getForObject(targetUrl, ApiResponse.class);

        return response;
    }
}