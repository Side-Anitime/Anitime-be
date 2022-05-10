package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.service.user.AuthService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@Api(tags = "로그인 하기전 인증")
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/init")
    public ResponseEntity<?> getTokenSave() throws NoSuchAlgorithmException, InvalidKeySpecException {
        try{
            Token token = authService.getTokenSave();
            System.out.println("token :" + token.getInitToken());
            System.out.println("token :" + token.getPrivateKey());
            System.out.println("token :" + token.getPublicKey());
            // token 값 리턴 필요함
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }
}
