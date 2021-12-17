package com.wirebarley.apply.controller;

import com.wirebarley.apply.dto.ApiResult;
import com.wirebarley.apply.service.MainService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MainController {

    @Setter(onMethod_ = @Autowired)
    private MainService mainService;

    //메인 페이지
    @GetMapping("/")
    public String getIndex(Model model){

        //환율 정보 조회
        ApiResult result = mainService.getExchangeRate();

        //로그 기록
        log.info("getIndex()");
        log.info(result.toString());

        //환율 정보 model에 담기
        model.addAttribute("apiResult", result);

        return "main";
    }


    //환율 조회
    @ResponseBody
    @GetMapping("/exchange-rate")
    public ApiResult getExchangeRate() {

        //환율 정보 조회
        ApiResult result = mainService.getExchangeRate();

        //로그 기록
        log.info("getExchangeRate()");
        log.info(result.toString());

        //실패여부 확인
        if(!result.isSuccess()) {
            log.info("errorInfo");
            log.info(result.getError().toString()); //에러 메세지 출력

            result.setError(null); //에러 메세지 지우기
        }

        return result;
    }

}
