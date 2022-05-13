package com.side.anitime.controller.plan;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.side.anitime.dto.PlanDTO;
import com.side.anitime.service.PlanService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@Api(value = "일정관련 API", tags = "일정관련 API")
public class PlanController {

    private final PlanService planService;
    
    @PostMapping("/save")
    public ResponseEntity<?> savePlan(@Valid @RequestBody PlanDTO.SaveReq vo){
    	try {
    		planService.savePlan(vo);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return ResponseEntity.ok(null);
    }
    
    @GetMapping("/calendar-view/{year}/{month}/{userToken}")
    public ResponseEntity<?> getCalendarViewList(
			  @RequestParam("year") String year
    		, @RequestParam("month") String month
    		, @RequestParam("userToken") String userToken
    		) throws Exception{
    	
    	JsonArray result = new JsonArray();
    	
    	try {
	    	PlanDTO.CalendarViewReq vo = new PlanDTO.CalendarViewReq(year, month, userToken);
	    	result = planService.getCalendarPlanByYearMonth(vo);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return ResponseEntity.ok(result.toString());
    	
    }
    
    @GetMapping("/category/types")
    public ResponseEntity<?> getPlanCategoryType(){
    	return ResponseEntity.ok(planService.getPlanCategoryTypeList());
    }
    
    @GetMapping("/colors")
    public ResponseEntity<?> getPlanColors(){
    	return ResponseEntity.ok(planService.getColorList());
    }
    
    @GetMapping("/alarm/types")
	public ResponseEntity<?> getAlarmTypes(){
	    	return ResponseEntity.ok(planService.getAlarmTypeList());
	}
    
}
