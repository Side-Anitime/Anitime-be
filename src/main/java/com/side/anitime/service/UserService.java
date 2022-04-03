package com.side.anitime.service;

import com.side.anitime.dto.RequestUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    public void joinUser(RequestUserDto.Join request) {
        //TODO:
        // 1. userType 확인
        // 2. 이메일 중복체크
        // 3. 사용자 기본정보 저장
        // 4. save
    }
}
