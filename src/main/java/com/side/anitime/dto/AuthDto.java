package com.side.anitime.dto;

import io.swagger.annotations.Api;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Api(tags = "토큰 정보 저장하기")
public class AuthDto {

    private String initToken;
    private String publicKey;
    private String privateKey;
//    @Getter
//    @Setter
//    @Api(tags = "initToken 정보 가져오기")
//    public static class reqToken {
//        private String initToken;
//    }

//    @Getter
//    @Setter
//    @Api(tags = "토큰 정보 저장하기")
//    public static class SaveToken {
//        private String initToken;
//        private String publicKey;
//        private String privateKey;
//    }
}
