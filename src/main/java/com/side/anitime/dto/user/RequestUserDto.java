package com.side.anitime.dto.user;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
    private String email;
    private String password;
    private String nickname;
}
