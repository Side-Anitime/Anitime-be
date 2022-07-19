package com.side.anitime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

public class TokenDTO {

    /**
     * Token Request 부분
     */


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reqVerify {
        private String initToken;
        private String email;
        private String password;
    }

    /**
     * Token Response 부분
     */

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class refreshUserToken {
        private String userToken;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class tokenDetail {
        private String initToken;
        private String publicKey;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class verifyInfo {
        private String initToken;
        private String email;
        @Lob
        private String encodeKey;
        private String decodeKey;
    }
}
