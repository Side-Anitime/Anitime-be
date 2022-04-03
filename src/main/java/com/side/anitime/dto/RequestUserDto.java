package com.side.anitime.dto;

import com.side.anitime.codeconst.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "유저 요청 DTO")
public class RequestUserDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(value = "사용자 가입 Request Dto")
    public static class Join {
        @NotBlank
        @Email(message = "이메일 형식으로 입력해주세요.")
        @ApiModelProperty(value = "이메일", position = 1, required = true)
        private String email;
        @NotBlank
        @ApiModelProperty(value = "닉네임", position = 2, required = true)
        private String nickname;
        @NotBlank
        @ApiModelProperty(value = "비밀번호", position = 3, required = true)
        private String password;
        @ApiModelProperty(value = "회원가입 계정 상태('NORMAL', 'NAVER', 'KAKAO')", position = 4)
        private UserType userType;
        //TODO: 서비스 이용 약관 동의, 개인 정보 수집 및 이용 동의
    }
}
