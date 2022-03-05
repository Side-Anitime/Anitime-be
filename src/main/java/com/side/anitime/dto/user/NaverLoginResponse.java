package com.side.anitime.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NaverLoginResponse {
    @Data
    @Builder
    public static class NaverAuthResponse {
        private String access_token;
        private String refresh_token;
        private String token_type;
        private int expires_in;
        private String error;
        private String error_description;
    }
}
