package com.side.anitime.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NaverController {

    @GetMapping("/naver-login")
    public String callbackNaverUrl(@RequestParam String code) {
        return "code : " + code;
    }
}
