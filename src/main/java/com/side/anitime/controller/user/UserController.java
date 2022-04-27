package com.side.anitime.controller.user;

import com.side.anitime.dto.user.RequestUserDto;
import com.side.anitime.dto.user.ResponseUserDto;
import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.service.user.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "일반 로그인")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/signin")
    public ResponseUserDto login(@RequestBody RequestUserDto requestUserDto){
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> join(@RequestBody RequestUserDto requestUserDto){
        userRepository.findByEmail(requestUserDto.getEmail());
        return null;
    }
}
