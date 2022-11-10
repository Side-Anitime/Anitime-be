package com.side.anitime.repository.user;

import com.side.anitime.domain.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import com.side.anitime.domain.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserToken(String userToken);

	@Query("select u from User u where u.email = :email and u.accountStatus='Y'")
	User findByUser(@Param("email") String email);

	@Query("select u from User u where u.email = :email and u.accountStatus='Y'")
	int findByUserCnt(@Param("email") String email);

//	@Query("select u from User u where Token.initToken = :initToken")
//	String tokenFindPw(@Param("initToken") String initToken);
//
	// initToken을 찾아서 userToken을 갱신해준다.
//	@Query("update User set userToken = :userToken where Token.initToken = :initToken")
//	String refreshUserToken(
//			  @Param("initToken") String initToken
//			, @Param("userToken") String userToken);



}
