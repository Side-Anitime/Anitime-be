package com.side.anitime.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestUserDto {

    private String email;
    private String password;
    private String initToken;

}
