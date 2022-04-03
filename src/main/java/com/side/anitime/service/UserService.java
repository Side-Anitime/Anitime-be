package com.side.anitime.service;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.dto.RequestUserDto;
import com.side.anitime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(RequestUserDto.Join request) {
        //TODO:
        // 1. userType 확인 (O)
        // 2. 이메일 중복체크 (O)
        // 3. 사용자 기본정보 저장
        // 4. save
        if (request.getUserType().equals(UserType.NORMAL)) {
            if (userRepository.countUserByEmail(request.getEmail()) > 0) {
                //exception 처리
            }
        }
    }
}
