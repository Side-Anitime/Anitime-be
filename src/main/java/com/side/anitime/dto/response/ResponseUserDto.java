package com.side.anitime.dto.response;

import com.side.anitime.codeconst.UserType;
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
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAccessToken {
        private String accessToken;
    }
    // TODO : Oauth 연동할 경우에 카카오나 네이버에서 받아오는 정보가 ID TYPE PICTURE 정보 정도면 되지않을까?
}
