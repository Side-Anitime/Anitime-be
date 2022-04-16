package com.side.anitime.service.auth;

import com.side.anitime.dto.auth.TokenProvider;
import com.side.anitime.dto.auth.TokenResponseDto;
import com.side.anitime.dto.user.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public TokenResponseDto login(UserLoginDto userLoginDto) {

        // username, password를 파라미터로 받고 이를 이용해 UsernamePasswordAuthenticationToken을 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword());

        // authenticationToken을 이용해서 Authenticaiton 객체를 생성하려고 authenticate 메소드가 실행될 때
        // CustomUserDetailsService에서 override한 loadUserByUsername 메소드가 실행된다.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // authentication 을 기준으로 jwt token 생성
        String jwt = tokenProvider.createToken(authentication);

        return new TokenResponseDto(jwt);
    }
}
