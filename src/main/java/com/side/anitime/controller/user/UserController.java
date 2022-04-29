package com.side.anitime.controller.user;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.user.RequestUserDto;
import com.side.anitime.dto.user.ResponseUserDto;
import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.service.user.UserService;
import com.side.anitime.util.CipherUtil;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(tags = "일반 로그인 API")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    // RSA 암호화 하기 위해 추가
    private final CipherUtil ciperUtil;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
        //Optional<User> findEmail = userService.findOneUser(email);
        //User user = userService.findOneUser(email).orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자 입니다.");
        User user = userService.findOneUser(email);
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

    @PostMapping("/join")
    public ResponseEntity<ResponseUserDto> join(@RequestBody User user){
        return null;
    }
}
