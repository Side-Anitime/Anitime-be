package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.UserDTO;
import com.side.anitime.service.user.AuthService;
import com.side.anitime.service.user.UserService;
import com.side.anitime.util.CipherUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "일반 로그인 API")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;
    private final CipherUtil cipherUtil;

    public ResponseEntity<?> login(@RequestBody UserDTO.reqUserToken reqUserToken){
        Token token = authService.findByKeypair(reqUserToken.getInitToken());
        //cipherUtil.decode();
        //cipherUtil.encode();

        return null;
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserDto.ReqUser userDto) throws NoSuchAlgorithmException, InvalidKeySpecException {
//
//            /* 유저정보와 넘어온 userToken 확인하여 사용자 정보 내려주기 */
//            User user = userService.findOneUser(userDto.getEmail());
//            return ResponseEntity.ok(
//                    UserDto.Detail.builder()
//                            .userId(user.getUserId())
//                            .email(user.getEmail())
//                            .nickname(user.getNickname())
//                            .userType(user.getUserType())
//                            .picture(user.getPicture())
//                            .build()
//
//            );
//        }
//        return null;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user){
        return ResponseEntity.ok(userService.join(user));
    }
}