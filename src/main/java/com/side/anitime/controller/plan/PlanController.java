package com.side.anitime.controller.plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.side.anitime.dto.PlanDTO;
import com.side.anitime.service.plan.PlanService;
import com.side.anitime.util.common.ApiCommResponse;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@Api(value = "일정관련 API", tags = "일정관련 API")
public class PlanController {

	private final PlanService planService;

	@PostMapping("/save")
	public ResponseEntity<?> savePlan(@Valid @RequestBody PlanDTO.SaveReq vo) {
		try {
			planService.savePlan(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity(ApiCommResponse.OK(), HttpStatus.OK);
	}

	@GetMapping("/calendar-view/{year}/{month}/{userToken}")
	public ResponseEntity<?> getCalendarViewList(@RequestParam("year") String year, @RequestParam("month") String month,
			@RequestParam("userToken") String userToken) throws Exception {

		List<HashMap<String,Object>> result = new ArrayList<>();

		try {
			PlanDTO.CalendarViewReq vo = new PlanDTO.CalendarViewReq(year, month, userToken);
			result = planService.getCalendarPlanByYearMonth(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(ApiCommResponse.OK(result), HttpStatus.OK);

	}

	@GetMapping("/category/types")
	public ResponseEntity<?> getPlanCategoryType() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getPlanCategoryTypeList()), HttpStatus.OK);
	}

	@GetMapping("/colors")
	public ResponseEntity<?> getPlanColors() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getColorList()), HttpStatus.OK);
	}

	@GetMapping("/alarm/types")
	public ResponseEntity<?> getAlarmTypes() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getAlarmTypeList()), HttpStatus.OK);
	}

}
