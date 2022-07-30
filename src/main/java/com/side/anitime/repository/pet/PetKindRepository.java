package com.side.anitime.repository.pet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.domain.pet.PetKind;

public interface PetKindRepository extends JpaRepository<PetKind, Long> {
	
	List<PetKind> findByTypeAndKindNameContains(AnimalType type, String kindName);
	
}
