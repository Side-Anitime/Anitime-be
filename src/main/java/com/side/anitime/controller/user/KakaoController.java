package com.side.anitime.controller.user;

import com.side.anitime.service.user.GetAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoController {

    @Autowired
    private GetAccessTokenService service;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/login/oauth2/code/kakao")
    public String getAuthCode(@RequestParam("code") String authorizationCode){
        service.getAccessToken(authorizationCode);
        return "main";
    }
}
