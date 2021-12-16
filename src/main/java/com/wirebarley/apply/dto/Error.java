package com.wirebarley.apply.dto;

import lombok.Data;

/**
 * API 결과가 false일 경우 반환값
 */

@Data
public class Error {
    private String code;
    private String type;
    private String info;
}
