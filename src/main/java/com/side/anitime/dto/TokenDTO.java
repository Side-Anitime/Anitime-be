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
    public static class reqUserToken {
        private String initToken;

        @Lob
        private String emailKey;
        @Lob
        private String passwordKey;
    }

    /**
     * Token Response 부분
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class tokenDetail {
        private String initToken;
        private String publicKey;
    }
}
