package com.side.anitime.repository.plan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.anitime.domain.category.PlanCategoryType;

public interface PlanCategoryTypeRepository extends JpaRepository<PlanCategoryType, Long> {
	
}
