package com.side.anitime.controller.user;

import com.side.anitime.domain.user.User;
import com.side.anitime.dto.UserDto;
import com.side.anitime.service.user.UserService;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import com.side.anitime.util.common.ResultCode;
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