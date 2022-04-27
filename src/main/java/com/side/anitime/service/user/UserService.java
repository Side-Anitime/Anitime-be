package com.side.anitime.service.user;

import com.side.anitime.domain.user.User;
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

    // 회원가입
    public Long join(User user) {
        duplicateUser(user);
        userRepository.save(user);
        return user.getUserId();
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

    @Transactional(readOnly = true)
    public User findOneUser(Long userId){
        // getById는 프록시
        return userRepository.getById(userId);
    }
}
