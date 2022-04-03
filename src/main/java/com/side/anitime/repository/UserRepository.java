package com.side.anitime.repository;

import com.side.anitime.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Long countUserByEmail(String email);
}
