package com.side.anitime.service;

import com.side.anitime.codeconst.UserType;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.RequestUserDto;
import com.side.anitime.exception.BadRequestException;
import com.side.anitime.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void joinUser(RequestUserDto.Join request) {
        if (request.getUserType().equals(UserType.NORMAL)) {
            if (userRepository.countUserByEmail(request.getEmail()) > 0) {
                throw new BadRequestException("errorCode", "이미 존재하는 사용자입니다.");
            }
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .userType(request.getUserType())
                .build());
    }
}
