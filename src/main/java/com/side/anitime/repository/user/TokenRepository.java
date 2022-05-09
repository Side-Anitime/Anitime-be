package com.side.anitime.repository.user;

import com.side.anitime.domain.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
