package com.side.anitime.dto.user;

import lombok.Builder;

@Builder
public class RequestUserDto {
    private String email;
    private String nickname;
    private String password;
}
