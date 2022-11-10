package com.side.anitime.dto;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.codeconst.YesNo;
import lombok.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.Lob;

public class UserDTO {

    /**
     * request DTO 부분
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reqJoinUser {
        private String email;
        private String nickname;
        private UserType userType;
        private YesNo accountStatus;
        @Lob
        private String password;
        @Lob
        private String userToken;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class reqUserToken {
        private String email;
        private String password;
//        private String userToken;
    }


    /**
     * response DTO 부분
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Detail {
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
