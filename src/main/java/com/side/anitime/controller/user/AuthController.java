package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.dto.TokenDto;
import com.side.anitime.service.user.AuthService;
import com.side.anitime.util.common.ApiCommResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/init")
    public ResponseEntity<TokenDto> getTokenSave() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Token token = null;
        try{
            token = authService.getTokenSave();
        }catch(Exception e){
            e.printStackTrace();
        }
//        return ResponseEntity.ok(null);
        return new ResponseEntity(ApiCommResponse.OK(TokenDto.tokenDetail.builder()
                .initToken(token.getInitToken())
                .publicKey(token.getPublicKey())
                .build()
        ), HttpStatus.CREATED);
    }
}
