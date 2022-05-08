package com.side.anitime.controller.user;

import com.side.anitime.domain.user.User;
import com.side.anitime.dto.user.RequestUserDto;
import com.side.anitime.dto.user.ResponseUserDto;
import com.side.anitime.service.user.UserService;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import com.side.anitime.util.common.CommonResponse;
import com.side.anitime.util.common.ResponseMessage;
import com.side.anitime.util.common.StatusCode;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

@RestController
@Api(tags = "일반 로그인 API")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    // RSA 암호화 하기 위해 추가
    private final CipherUtil ciperUtil;
    private final RandomSecure randomSecure;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestUserDto requestUserDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        Optional<?> requestToken = Optional.ofNullable(requestUserDto.getInitToken());
//        HashMap<String, String> rsaKeyPair = ciperUtil.createKeypairAsString();
//        String publicKey = rsaKeyPair.get("publicKey"); // 공개키
//        String privateKey = rsaKeyPair.get("privateKey"); // 개인키
//
//        System.out.println(publicKey);
//        System.out.println(privateKey);

        if(requestUserDto.getInitToken() == null || requestUserDto.getInitToken() == ""){
            // initToken 생성
            String initToken = randomSecure.generate();
            /* RSA 로직 활용 & DB에 넣어주기 */


            return new ResponseEntity(CommonResponse.res(StatusCode.UNAUTHORIZED, ResponseMessage.NOT_FOUND_USER,
                    ResponseUserDto.GetInitToken.builder()
                            .initToken(initToken)
                            .build()), HttpStatus.OK);
        }else{
            /* 넘어온 initToken을 가지고 해당 공개키 내려주기 */

            User user = userService.findOneUser(requestUserDto.getEmail());
            return ResponseEntity.ok(
                    ResponseUserDto.Detail.builder()
                            .userId(user.getUserId())
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .userType(user.getUserType())
                            .picture(user.getPicture())
                            .build()

            );
        }
//        return null;
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user){
        return ResponseEntity.ok(userService.join(user));
    }
}
