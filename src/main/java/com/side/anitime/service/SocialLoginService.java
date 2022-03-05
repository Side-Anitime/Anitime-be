package com.side.anitime.service;

import com.side.anitime.dto.user.NaverLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface SocialLoginService {
    NaverLoginResponse.NaverAuthResponse getAccessToken(String authorizationCode);
}
