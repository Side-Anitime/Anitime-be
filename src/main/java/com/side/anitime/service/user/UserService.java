package com.side.anitime.service.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.UserDTO;
import com.side.anitime.repository.user.TokenRepository;
import com.side.anitime.repository.user.UserRepository;
import com.side.anitime.util.CipherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final CipherUtil cipherUtil;
    private final AuthService authService;

    // 로그인 시 토큰 정보 넣어주기
    public void tokenRegister(Token token){
        tokenRepository.save(token);
    }

    // 로그인 전 체크하는 로직
    public UserDTO checkBeforeLogin(UserDTO.reqUserToken userDto) {
        // 1. 파라미터로 넘어온 값을 가지고 이메일이 디비에 있는지 확인
        // 2. 이메일이 있다면 암호화된 패스워드를 복호화하여 패스워드가 일치하는지 확인
        // 3. 둘다 맞다면 OK Status 내려줌과 동시에 사용자 정보 내려주기
        if(userRepository.findOneEmail(userDto.getEmail()) < 0){
            throw new IllegalStateException("존재하지 않는 이메일 입니다.");
        }
        String initToken = userDto.getInitToken();
        // initToken으로 개인키 가져오기
        Token token = authService.findByKeypair(initToken);
        String decodePw = cipherUtil.decode(userDto.getPasswordKey(), token.getPrivateKey());
        String originPw = findPassword(initToken);

        if(!originPw.equals(decodePw)){
            throw new IllegalStateException("패스워드가 일치하지 않습니다.");
        }

        return null;
    }

    // 토큰으로 패스워드 찾기
    public String findPassword(String initToken){
        return userRepository.tokenFindPw(initToken);
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
}