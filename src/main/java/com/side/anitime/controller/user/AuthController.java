package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.AuthDto;
import com.side.anitime.dto.UserDto;
import com.side.anitime.repository.user.TokenRepository;
import com.side.anitime.service.user.TokenService;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

@RestController
@Api(tags = "로그인 하기전 인증")
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenRepository tokenRepository;
    private final RandomSecure randomSecure;
    private final CipherUtil cipherUtil;
    private final TokenService tokenService;

    @PostMapping(value = "/init")
    public ResponseEntity<?> createToken(@RequestBody AuthDto.reqToken authDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
        /**
         * initToken이 없다면 initToken을 만들고 publicKey와 같이 내려주기
         */
            // initToken 생성
            String initToken = randomSecure.generate();
            /* RSA 로직 활용 & DB에 넣어주기 */
            HashMap<String, String> rsaKeyPair = cipherUtil.createKeypairAsString();
            String publicKey = rsaKeyPair.get("publicKey"); // 공개키
            String privateKey = rsaKeyPair.get("privateKey"); // 개인키
//            tokenService.tokenRegister();

        return null;
    }
}
