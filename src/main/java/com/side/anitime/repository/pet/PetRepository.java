package com.side.anitime.repository.pet;

import java.time.LocalDateTime;
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
	
	@Modifying
    @Query(value ="UPDATE pet P SET P.update_date = NOW()"
    		+ ", P.birthday = :birthday"
    		+ ", P.gender = :gender"
    		+ ", P.name = :name"
    		+ ", P.neuter_yn = :neuterYn"
    		+ ", P.personality = :personality"
    		+ ", P.represent_yn = :representYn "
    		+ ", P.pet_kind_id = :petKindId"
    		+ ", P.short_introduce = :shortIntroduce"
    		+ ", P.first_meet_date = :firstMeetDate"
    		+ "  WHERE P.pet_id = :petId", nativeQuery = true)
    void updatePetByPetId(
    		  @Param("birthday") LocalDateTime birthday
    		, @Param("gender") String gender
    		, @Param("name") String name
    		, @Param("neuter_yn") String neuterYn
    		, @Param("personality") String personality
    		, @Param("representYn") String representYn
    		, @Param("petKindId") Long petKindId
    		, @Param("shortIntroduce") String shortIntroduce
    		, @Param("firstMeetDate") LocalDateTime firstMeetDate
    		, @Param("petId") Long petId
    		);
	
	
	
}
