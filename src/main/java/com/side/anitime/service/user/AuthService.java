package com.side.anitime.service.user;

import com.side.anitime.domain.setting.dto.UserDTO;
import com.side.anitime.domain.user.Token;
import com.side.anitime.dto.TokenDTO;
import com.side.anitime.dto.UserDTO;
import com.side.anitime.repository.user.TokenRepository;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import com.side.anitime.util.common.ApiCommResponse;
import com.side.anitime.util.common.ResultCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        String initToken = randomSecure.initGenerate();

        /**
         * TODO initToken 값이 디비에 있는 지 확인해서 없으면 재생성 로직 추가
         */

        token.setInitToken(initToken);
        token.setPublicKey(publicKey);
        token.setPrivateKey(privateKey);

        tokenRepository.save(token);

        return token;
    }
    // initToken, email, password
    public void setRefreshToken(TokenDTO.reqVerify tokenDto) {
    }
}
