package service;


import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class MainService {
    public static void main(String[] args) {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(5000); // 읽기시간초과, ms
//        factory.setConnectTimeout(3000); // 연결시간초과, ms
//        HttpClient httpClient =  HttpClientBuilder.create()
//                .setMaxConnTotal(100) // connection pool 적용
//                .setMaxConnPerRoute(5) // connection pool 적용
//                .build();
//        factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
        RestTemplate restTemplate = new RestTemplate();


        String apiServerHost = "http://api.currencylayer.com/live";

        Map<String, String> params = new HashMap<>();
        params.put("access_key","none");

        Object obj = restTemplate.getForObject(apiServerHost, Map.class, params);
        System.out.println(obj);
    }
}
