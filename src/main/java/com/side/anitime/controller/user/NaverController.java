package com.side.anitime.controller.user;

import com.side.anitime.dto.user.NaverLoginResponse;
import com.side.anitime.service.SocialLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NaverController {

    private final SocialLoginService socialLoginService;

    @GetMapping("/naver-login")
    public String doNaverLogin(@RequestParam String code) {
        NaverLoginResponse.NaverAuthResponse accessToken = socialLoginService.getAccessToken(code);
        return "accessToken : " + accessToken;
    }
}
