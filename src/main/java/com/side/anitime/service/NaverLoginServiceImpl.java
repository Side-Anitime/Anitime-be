package com.side.anitime.service;


import com.side.anitime.dto.user.NaverLoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


public class NaverLoginServiceImpl implements SocialLoginService {

    @Value("${social.client.naver.client-id}")
    private String naverClientId;
    @Value("${social.client.naver.client-secret}")
    private String naverClientSecret;
    @Value("${social.client.naver.redirect-url}")
    private String naverRedirectUrl;
    @Value("${social.client.naver.grant_type}")
    private String naverGrantType;
    @Value("${social.client.naver.state}")
    private String naverState;


    @Override
    public NaverLoginResponse.NaverAuthResponse getAccessToken(String authorizationCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", naverGrantType);
        params.add("client_id", naverClientId);
        params.add("client_secret", naverClientSecret);
        params.add("state", naverState);
        params.add("code", authorizationCode);


        // restTemplate.getForObject("https://nid.naver.com/oauth2.0/token?")


        return null;
    }
}
