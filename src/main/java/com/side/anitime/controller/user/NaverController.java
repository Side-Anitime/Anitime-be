package com.side.anitime.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/naver")
@RequiredArgsConstructor
public class NaverController {

    @GetMapping("/auth")
    public String callbackNaverUrl(@RequestParam String code) {
        return "code : " + code;
    }
}
