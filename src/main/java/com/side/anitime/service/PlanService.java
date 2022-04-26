package com.side.anitime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.category.PlanCategoryType;
import com.side.anitime.repository.plan.PlanCategoryTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanCategoryTypeRepository planCategoryTypeRepository;
    
    public List<PlanCategoryType> getPlanCategoryTypeList(){
    	return planCategoryTypeRepository.findAll();
    }
    
}
