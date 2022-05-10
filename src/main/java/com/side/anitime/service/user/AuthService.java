package com.side.anitime.service.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.dto.AuthDto;
import com.side.anitime.repository.user.TokenRepository;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Transactional
@RequiredArgsConstructor
@Service
public class AuthService {

    private final TokenRepository tokenRepository;
    private final RandomSecure randomSecure;
    private final CipherUtil cipherUtil;
//    private final Token token;

    public Token getTokenSave(){
        /**
         * initToken은 무조건 생성해서 내려주기
         * DB에 쌓아두고 있다가 날짜 기준으로 어느정도 쌓일 경우 삭제 처리
         */
        /* RSA 로직 활용 & DB에 넣어주기 */
        Token token = new Token();
        HashMap<String, String> rsaKeyPair = cipherUtil.createKeypairAsString();
        String publicKey = rsaKeyPair.get("publicKey"); // 공개키
        String privateKey = rsaKeyPair.get("privateKey"); // 개인키
        // initToken 생성
        String initToken = randomSecure.generate();

        token.setInitToken(initToken);
        token.setPublicKey(publicKey);
        token.setPrivateKey(privateKey);

        tokenRepository.save(token);

        return token;
    }
}
