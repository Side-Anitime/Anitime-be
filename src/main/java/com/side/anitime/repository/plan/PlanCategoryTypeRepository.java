package com.side.anitime.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.plan.PlanCategory;

public interface PlanCategoryTypeRepository extends JpaRepository<PlanCategory, Long> {
	
}
