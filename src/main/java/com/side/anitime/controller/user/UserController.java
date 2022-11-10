package com.side.anitime.controller.user;

import com.side.anitime.codeconst.UserType;
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
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@Api(tags = "로그인과 회원가입 API")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    /**
     * @param userDto (email, password)
     * @return UserDto.detail
     */
    @ApiOperation(httpMethod = "POST", value = "로그인", notes="등록된 정보 확인 후 로그인 합니다.")
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO.reqUserToken userDto) {
        User user = new User();
        try {
            user = userService.checkBeforeLogin(userDto);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR_INVALID_PASSWORD), ResultCode.ERROR_INVALID_PASSWORD.getStatus());
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR_EMAIL_NOT_FOUND), ResultCode.ERROR_EMAIL_NOT_FOUND.getStatus());
        }
        /* 세션 생성하여 로그인 성공시 세션에 정보 담기 */

        return new ResponseEntity(ApiCommResponse.OK(UserDTO.Detail.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .userType(user.getUserType())
                .userToken(user.getUserToken())
                .build()
        ), HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "POST", value = "회원가입", notes="등록된 사용자 확인 후 회원을 등록합니다.")
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserDTO.reqJoinUser userDto){
        try {
            userService.join(userDto);
            return new ResponseEntity(ApiCommResponse.OK(ResultCode.OK_CREATED), ResultCode.OK_CREATED.getStatus());
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR_EMAIL_DUPLICATE), ResultCode.ERROR_EMAIL_DUPLICATE.getStatus());
        }
    }
}