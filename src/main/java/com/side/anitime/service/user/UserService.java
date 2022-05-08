package com.side.anitime.service.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import com.side.anitime.repository.user.TokenRepository;
import com.side.anitime.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
// final이 있는 필드만 가지고 생성자 생성
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    // 로그인 시 토큰 정보 넣어주기
    public void tokenRegister(Token token){
        tokenRepository.save(token);
    }

    // 회원가입
    public String join(User user) {
        duplicateUser(user);
        userRepository.save(user);
        return user.getEmail();
    }

    // 중복 회원 확인
    private void duplicateUser(User user){
        Optional<User> findUser = userRepository.findByEmail(user.getEmail());
        if(!findUser.isEmpty()){
            throw new IllegalStateException("존재하는 회원 입니다.");
        }
    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<User> findUsers(){
        return userRepository.findAll();
    }

    // 회원 단건 조회
    @Transactional(readOnly = true)
    public User findOneUser(String email) {
        User user = userRepository.findOneEmail(email);
        return user;
    }
}
