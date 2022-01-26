package com.side.anitime.controller.plan;

import com.side.anitime.domain.category.PlanCategory;
import com.side.anitime.domain.plan.Plan;
import com.side.anitime.dto.plan.ResponsePlanDto;
import com.side.anitime.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanRepository planRepository;

    @GetMapping("{planId}")
    public ResponseEntity<?> getPlanList(@PathVariable Long planId){
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new IllegalStateException("Error~"));

        return ResponseEntity.ok(
                ResponsePlanDto.Detail.builder()
                        .planId(plan.getPlanId())
                        .title(plan.getTitle())
                        .contents(plan.getContents())
                        .planCategory(plan.getPlanCategory())
                        .alarms(plan.getAlarms())
                        .build()
        );
    }

}
