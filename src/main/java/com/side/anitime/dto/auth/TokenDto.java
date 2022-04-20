package com.side.anitime.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
}