package com.side.anitime.dto.user.oauth2;

import java.util.Arrays;
import java.util.Map;

public enum OauthAttributes {
    KAKAO("kakao") {
        @Override
        public UserProfile of(Map<String, Object> attributes) {
        // 카카오는 kakao_account에 유저정보가 있음
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        // kakao_account 안에 또 profile이라는 JSON 객체가 이어서 존재함 (nickname, profile_image)
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return UserProfile.builder()
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .imageUrl((String) kakaoProfile.get("profile_image_url"))
                .build();
        }
    };

    private final String providerName;

    OauthAttributes(String name) {
        this.providerName = name;
    }

    public static UserProfile extract(String providerName, Map<String, Object> attributes) {
        return Arrays.stream(values())
                     .filter(provider -> providerName.equals(provider.providerName))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new)
                     .of(attributes);
    }

    public abstract UserProfile of(Map<String, Object> attributes);
}
