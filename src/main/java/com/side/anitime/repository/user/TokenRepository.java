package com.side.anitime.repository.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    //Optional<Token> findByToken(String initToken);
}
