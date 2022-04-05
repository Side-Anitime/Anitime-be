package com.side.anitime.controller.user;

import com.side.anitime.repository.user.UserRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "oauth2 로그인")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //TODO: API 설계 확인하여 swagger 껍데기 만들기

    private final UserRepository userRepository;
}
