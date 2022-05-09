package com.side.anitime.service.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.repository.user.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    // initToken 으로 토큰 정보 찾기
    public void tokenRegister(Token token){
        tokenRepository.save(token);
    }

}
