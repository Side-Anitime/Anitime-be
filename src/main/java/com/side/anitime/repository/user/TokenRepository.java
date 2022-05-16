package com.side.anitime.repository.user;

import com.side.anitime.domain.user.Token;
import com.side.anitime.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("select t from Token t where t.initToken = :initToken")
    Token findByKey(@Param("initToken") String initToken);
//    TODO No property id found for type Token! 에러나면서 못찾음
//    Token findById(String initToken);
}
