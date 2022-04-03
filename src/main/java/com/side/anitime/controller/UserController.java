package com.side.anitime.controller;

import com.side.anitime.dto.RequestUserDto;
import com.side.anitime.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@Api(value = "회원 관리 API", tags = "회원 API")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "successfully join user")
    })
    @PostMapping
    public ResponseEntity<?> joinUser(@RequestBody RequestUserDto.Join request) {
        userService.joinUser(request);
        return ResponseEntity.ok(null);
    }
}
