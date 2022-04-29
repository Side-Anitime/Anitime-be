package com.side.anitime.controller.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.domain.user.User;
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

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String findEmail = userService.findOneUser(user.getEmail());
        System.out.println(findEmail);
        return null;

//        return ResponseEntity.ok(
//                ResponseUserDto.Detail.builder()
//                        .userId(user.getUserId())
//                        .email(user.getEmail())
//                        .nickname(user.getNickname())
//                        .userType(user.getUserType())
//                        .picture(user.getPicture())
//                        .build()
//
//        );
    }

    @PostMapping("/join")
    public ResponseEntity<ResponseUserDto> join(@RequestBody User user){
        return null;
    }
}
