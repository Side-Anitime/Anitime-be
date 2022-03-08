package com.side.anitime.service;


import com.google.gson.Gson;
import com.side.anitime.dto.user.NaverLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverLoginServiceImpl implements SocialLoginService {

    private String naverClientId = "_1htrmE0J9gJikfSSrAD";
    private String naverClientSecret = "2cq4Dekkhw";
    private String naverGrantType = "authorization_code";
    private String state = "anitime";


    @Override
    public NaverLoginResponse.NaverAuthResponse getAccessToken(String authorizationCode) {
        ResponseEntity<?> response = requestAccessToken(generateAuthCodeRequest(authorizationCode));
        log.info("response [{}]", response);
        NaverLoginResponse.NaverAuthResponse naverAuthResponse = new Gson().fromJson(String.valueOf(response.getBody()), NaverLoginResponse.NaverAuthResponse.class);
        log.info("naverAuthResponse [{}]", naverAuthResponse);
        return naverAuthResponse;
    }

    private HttpEntity<MultiValueMap<String, String>> generateAuthCodeRequest(String authorizationCode) {
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", naverGrantType);
        params.add("client_id", naverClientId);
        params.add("client_secret", naverClientSecret);
        params.add("code", authorizationCode);
        return new HttpEntity<>(params, header);
    }

    private ResponseEntity<String> requestAccessToken(HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();
        log.info("request [{}]", request);
        return restTemplate.exchange(
                "https://nid.naver.com/oauth2.0/token",
                HttpMethod.POST,
                request,
                String.class
        );
    }
}
