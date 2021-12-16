package com.wirebarley.apply.dto;

import lombok.Data;

/**
 * API 조회 결과를 담을 클래스
 */

@Data
public class ApiResponse {
    private boolean success; //성공 여부
    private Error error; //에러 정보
    private Quotes quotes; //시세 정보
}
