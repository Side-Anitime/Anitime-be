package com.side.anitime.dto.user;

import com.side.anitime.codeconst.Role;
import com.side.anitime.codeconst.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponseUserDto {

    @Builder
    public static class Detail {
        private Long userId;
        private String password;
        private String name;
        private Role role;
    }
    // TODO 일반 회원가입의 경우 Detail 메서드

//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class Detail {
//        private Long userId;
//        private String email;
//        private String nickname;
//        private UserType userType;
//        private String picture;
//    }
    // TODO 소셜 로그인의 경우 Detail 메서드를 통해 상세 정보를 가져오는데 프론트에서 함으로 일단 주석 처리

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAccessToken {
        private String accessToken;
    }


    // TODO : Oauth 연동할 경우에 카카오나 네이버에서 받아오는 정보가 ID TYPE PICTURE 정보 정도면 되지않을까?
}
