package com.side.anitime.controller.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.dto.user.ResponseUserDto;
import com.side.anitime.repository.UserRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "oauth2 로그인")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
//    @PostMapping(/login/{userType})
//    public ResponseEntity<?> oauthLoginUser(@PathVariable UserType userType){
//
//        return ResponseEntity.ok();
//    }
}
