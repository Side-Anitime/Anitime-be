package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.dto.TokenDTO;
import com.side.anitime.service.user.AuthService;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.common.ApiCommResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "로그인 하기전 인증")
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CipherUtil cipherUtil;

    @GetMapping(value = "/init")
    public ResponseEntity<TokenDTO> getTokenSave() throws Exception {
        Token token = null;
        try{
            token = authService.getTokenSave();
        }catch(Exception e){
            e.printStackTrace();
        }
//        return ResponseEntity.ok(null);
        return new ResponseEntity(ApiCommResponse.OK(TokenDTO.tokenDetail.builder()
                .initToken(token.getInitToken())
                .publicKey(token.getPublicKey())
                .build()
        ), HttpStatus.CREATED);
    }


    @PostMapping(value = "/verify")
    //public ResponseEntity<?> getVerifyToken(TokenDTO.reqUserToken tokenDto) throws Exception {
    public ResponseEntity<?> getVerifyToken(TokenDTO.reqVerify tokenDto) throws Exception {
        String initToken = tokenDto.getInitToken();
        // TODO initToken 으로 DB에 등록된 키 값 가져오기
        Token token = authService.findByKeypair(initToken);
        String encStr = cipherUtil.encode(tokenDto.getPassword(), token.getPublicKey());
        String decodeStr = cipherUtil.decode(encStr, token.getPrivateKey());

        return new ResponseEntity(ApiCommResponse.OK(TokenDTO.verifyInfo.builder()
                .initToken(token.getInitToken())
                .encodeKey(encStr)
                .decodeKey(decodeStr)
                .email(tokenDto.getEmail())
                .build()
        ), HttpStatus.OK);
    }
}
