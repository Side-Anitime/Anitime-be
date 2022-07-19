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

    /**
     * @param userDto (initToken, email, passwordKey)
     * @return
     */
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO.reqUserToken userDto) {
        userService.checkBeforeLogin(userDto);

        return null;
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody User user){
        return ResponseEntity.ok(userService.join(user));
    }
}