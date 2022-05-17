package com.side.anitime.repository.user;

import com.side.anitime.domain.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import com.side.anitime.domain.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserToken(String userToken);
	Optional<User> findByEmail(String email);

	@Query("select u from User u where u.email = :email")
	User findOneEmail(@Param("email") String email);
}
