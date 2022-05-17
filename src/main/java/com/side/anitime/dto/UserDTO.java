package com.side.anitime.dto;

import com.side.anitime.codeconst.UserType;
import lombok.*;

import javax.persistence.Lob;

public class UserDTO {

    /**
     * request DTO 부분
     */

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reqUserToken {
        private String initToken;
        private String email;
        @Lob
        private String passwordKey;
    }


    /**
     * response DTO 부분
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
        private Long userId;
        private String email;
        private String nickname;
        private UserType userType;
        private String picture;
        private String userToken;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAccessToken {
        private String accessToken;
    }
}
