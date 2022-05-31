package com.side.anitime.repository.pet;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.side.anitime.domain.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	@Query(value = "SELECT P.* FROM pet P JOIN user U ON P.user_id = U.user_id"
						  + " WHERE U.user_token=:user_token", nativeQuery = true)
	List<Pet> findPetListByUserToken(@Param("user_token") String userToken);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM pet WHERE user_id=:user_id AND pet_id =:pet_id", nativeQuery = true)
	void deleteByUserTokenAndPetId(@Param("user_id") Long userId
													, @Param("pet_id") Long petId);
	
}
