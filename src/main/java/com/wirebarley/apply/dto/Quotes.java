package com.wirebarley.apply.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * API 결과가 true일 경우 반환값
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quotes implements Serializable {
    @JsonProperty("USDKRW")
    private Double krw;

    @JsonProperty("USDJPY")
    private Double jpy;

    @JsonProperty("USDPHP")
    private Double php;
}
