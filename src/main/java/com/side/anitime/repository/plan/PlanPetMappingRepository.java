package com.side.anitime.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.plan.PlanPetMapping;

public interface PlanPetMappingRepository extends JpaRepository<PlanPetMapping, Long> {
	
}
