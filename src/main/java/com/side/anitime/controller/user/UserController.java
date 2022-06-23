package com.side.anitime.controller.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.TokenDTO;
import com.side.anitime.dto.UserDTO;
import com.side.anitime.service.user.AuthService;
import com.side.anitime.service.user.UserService;
import com.side.anitime.util.CipherUtil;
import com.side.anitime.util.RandomSecure;
import com.side.anitime.util.common.ApiCommResponse;
import com.side.anitime.util.common.ResultCode;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final RandomSecure randomSecure;

    @PostMapping(value = "/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO.reqUserToken userDto){
//        String initToken = userDto.getInitToken();
//        Token token = authService.findByKeypair(initToken);
//        String decodePw = cipherUtil.decode(userDto.getPasswordKey(), token.getPrivateKey());
//        User user = userService.findOneUser(userDto.getEmail());

        authService.findByKeypair(userDto);
        User user = userService.findOneUser(userDto.getEmail());

        // 등록한 이메일이 있는지 체크


        return new ResponseEntity(ApiCommResponse.OK(UserDTO.Detail.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .userType(user.getUserType())
                .picture(user.getPicture())
//                .userToken(userToken)
                .build()
        ), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user){
        // TODO userToken 생성해주는 부분 추가 필요
        String userToken = randomSecure.userGenerate();
        return ResponseEntity.ok(userService.join(user));
    }
}