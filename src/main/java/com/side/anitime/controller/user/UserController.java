package com.side.anitime.controller.user;

import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(value = "회원 API", tags = "회원 API")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("social-login/naver")
    public ResponseEntity<?> socialLogin() {
        //TODO: socialType을 받아 공통의 메서드로 처리 ex)  socialType: KAKAO, NAVER...
        return ResponseEntity.ok(null);
    }


}
