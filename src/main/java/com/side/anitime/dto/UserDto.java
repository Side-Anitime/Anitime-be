package com.side.anitime.dto;

import com.side.anitime.codeconst.UserType;
import lombok.*;

public class UserDto {

    /**
     * request DTO 부분
     */


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
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetInitToken {
        private String initToken;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAccessToken {
        private String accessToken;
    }


}
