package com.side.anitime.repository.pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.side.anitime.domain.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
	@Query(value = "SELECT P.* FROM pet P JOIN user U ON P.user_id = U.user_id"
						  + " WHERE U.user_token=:user_token", nativeQuery = true)
	List<Pet> findPetListByUserToken(@Param("user_token") String userToken);
	
}
