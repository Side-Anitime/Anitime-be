package com.side.anitime.repository.plan;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.side.anitime.domain.plan.Plan;
import com.side.anitime.domain.plan.PlanPetMapping;

@Transactional
public interface PlanPetMappingRepository extends JpaRepository<PlanPetMapping, Long> {
	
	@Modifying
	void deleteByPlan(Plan plan);
	
}
