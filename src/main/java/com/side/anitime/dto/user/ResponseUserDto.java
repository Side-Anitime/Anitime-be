package com.side.anitime.dto.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.domain.user.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponseUserDto {

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
        private Token token;
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
