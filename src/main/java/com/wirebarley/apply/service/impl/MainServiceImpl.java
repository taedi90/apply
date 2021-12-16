package com.wirebarley.apply.service.impl;

import com.wirebarley.apply.dto.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.wirebarley.apply.service.MainService;

import java.net.URI;


@Service
public class MainServiceImpl implements MainService {

    static final String BASE_URL = "http://api.currencylayer.com/live";   //환율 API 기본 경로

    public ApiResponse getExchangeRate() {

        //URL 설정
        URI targetUrl = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("access_key", "2f892e04cfea43b6c43ee08f92dfc7b71")
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        ApiResponse response = restTemplate.getForObject(targetUrl, ApiResponse.class);

        return response;
    }
}