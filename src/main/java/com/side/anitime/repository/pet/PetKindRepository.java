package com.side.anitime.repository.pet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.pet.PetKind;

public interface PetKindRepository extends JpaRepository<PetKind, Long> {
	
	
}
