package com.side.anitime.controller.plan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.side.anitime.domain.plan.Plan;
import com.side.anitime.dto.plan.ResponsePlanDto;
import com.side.anitime.repository.plan.PlanRepository;
import com.side.anitime.service.PlanService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@Api(value = "일정관련 API", tags = "일정관련 API")
public class PlanController {

    //TODO: API 설계 확인하여 swagger 껍데기 만들기
    private final PlanRepository planRepository;
    private final PlanService planService;

    @GetMapping("{planId}")
    public ResponseEntity<?> getPlanList(@PathVariable Long planId){
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException("test"));

        return ResponseEntity.ok(
                ResponsePlanDto.Detail.builder()
                        .planId(plan.getPlanId())
                        .title(plan.getTitle())
                        .contents(plan.getContents())
                        .build()
        );
    }
    
    @GetMapping("/category/types")
    public ResponseEntity<?> getPlanCategoryType(){
    	return ResponseEntity.ok(planService.getPlanCategoryTypeList());
    }
    
}
