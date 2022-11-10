package com.side.anitime.service.user;

import com.side.anitime.domain.user.User;
import com.side.anitime.dto.UserDTO;
import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.util.EncryptionUtils;
import com.side.anitime.util.RandomSecure;
import com.side.anitime.util.common.ResultCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RandomSecure randomSecure;
    private final EncryptionUtils encryptionUtils = new EncryptionUtils();

    // 로그인 전 체크하는 로직
    public User checkBeforeLogin(UserDTO.reqUserToken userDto) {
        // 등록된 이메일이 있는지 체크
        User findUser = userRepository.findByUser(userDto.getEmail());
        if(findUser.getEmail() == null || findUser.getEmail() == ""){
            throw new RuntimeException();
        }
        // 패스워드 불일치 확인
        if(!encryptionUtils.encryptSHA256(userDto.getPassword()).equals(findUser.getPassword())){
            throw new IllegalArgumentException();
        }
        // encryptionUtils.encryptSHA256(userDto.getPassword()) != findUser.getPassword() ||
        return findUser;
    }

    /**
     * 회원 가입
     */
    public void join(UserDTO.reqJoinUser userDto) {
        duplicateUser(userDto.getEmail());
        User saveUser = new User();
        saveUser.setEmail(userDto.getEmail());
        saveUser.setPassword(encryptionUtils.encryptSHA256(userDto.getPassword()));
        saveUser.setUserType(userDto.getUserType());
        //saveUser.setAccountStatus(userDto.getAccountStatus());
        saveUser.setUserToken(randomSecure.userGenerate());

        userRepository.save(saveUser);
    }
    /**
     * 중복 회원 확인
     */
    private void duplicateUser(String email) {
        int findUserCnt = userRepository.findByUserCnt(email);
        System.out.println("::::findUserCnt :"+findUserCnt);
        if(findUserCnt > 0){
            throw new IllegalArgumentException();
        }
    }
}