package com.side.anitime.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TokenDto {

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
