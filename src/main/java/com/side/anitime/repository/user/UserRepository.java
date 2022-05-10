package com.side.anitime.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.side.anitime.domain.user.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUserToken(String userToken);
	Optional<User> findByEmail(String email);
//	User findOneEmail(String email);
}
