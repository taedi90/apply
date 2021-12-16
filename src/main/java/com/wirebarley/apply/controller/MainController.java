package com.wirebarley.apply.controller;

import com.wirebarley.apply.dto.ApiResponse;
import com.wirebarley.apply.service.MainService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MainController {

    @Setter(onMethod_ = @Autowired)
    private MainService mainService;

    @GetMapping("/")
    public String getIndex(Model model){

        ApiResponse response = mainService.getExchangeRate();

        log.info(response.toString());

        model.addAttribute("response", response);

        return "main";
    }


    //
    @ResponseBody
    @PostMapping("/exchange-rate")
    public ApiResponse getExchangeRate() {
        //컨트롤러 분리 여부

        //오류 내용 지우기

        return mainService.getExchangeRate();
    }

}
