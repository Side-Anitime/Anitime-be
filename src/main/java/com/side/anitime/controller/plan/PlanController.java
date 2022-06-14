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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.side.anitime.domain.plan.Plan;
import com.side.anitime.dto.PlanDTO;
import com.side.anitime.dto.PlanDTO.CalendarViewReq;
import com.side.anitime.dto.PlanDTO.ModifyPlanReq;
import com.side.anitime.service.plan.PlanService;
import com.side.anitime.util.common.ApiCommResponse;
import com.side.anitime.util.common.ResultCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
@Api(value = "일정관련 API", tags = "일정관련 API")
public class PlanController {

	private final PlanService planService;

	@ApiOperation(value = "일정 등록", notes="일정을 등록합니다. 반려 동물 마다 일정 등록 가능합니다.")
	@PostMapping("/save")
	public ResponseEntity<?> savePlan(@Valid @RequestBody PlanDTO.SavePlanReq vo) {
		try {
			planService.savePlan(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity(ApiCommResponse.OK(), HttpStatus.OK);
	}
	
	@ApiOperation(httpMethod = "PUT", value = "일정 수정", notes="사용자가 등록한 일정을 수정합니다.")
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public ResponseEntity<?> modifyUserPlan(@Valid @RequestBody ModifyPlanReq vo){
    	
		try {
			 planService.updatePlanByUserId(vo);
	    	 return new ResponseEntity(ApiCommResponse.OK(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			 return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR), ResultCode.ERROR.getStatus());
		}
    	 
	}

	@ApiOperation(value = "달에 따라서 일정 목록 조회", notes="앱에서 일정 탭을 클릭하여 달력을 확인할 경우에 사용합니다.")
	@GetMapping("/calendar-view/{year}/{month}/{userToken}")
	public ResponseEntity<?> getCalendarViewList(@RequestParam("year") String year, @RequestParam("month") String month,
			@RequestParam("userToken") String userToken) throws Exception {

		List<HashMap<String,Object>> result = new ArrayList<>();

		try {
			CalendarViewReq vo = new CalendarViewReq(year, month, userToken);
			result = planService.getCalendarPlanByYearMonth(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(ApiCommResponse.OK(result), HttpStatus.OK);

	}
	
	@ApiOperation(value = "해당 날짜에 해당하는 일정 목록 조회", notes="앱에서 특정 날짜를 클릭할 경우 사용합니다.")
	@GetMapping("/one-day/{year}/{month}/{day}/{userToken}")
	public ResponseEntity<?> getFindOnePlan(
			  @RequestParam("year") String year
			, @RequestParam("month") String month
			, @RequestParam("day") String day
			, @RequestParam("userToken") String userToken) throws Exception {

		List<Plan> result = new ArrayList<>();

		try {
			result = planService.getFindPlansByDate(year, month, day, userToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity(ApiCommResponse.OK(result), HttpStatus.OK);

	}

	@ApiOperation(value = "일정 카테고리 목록을 조회", notes="일정 카테고리 목록을 조회합니다.")
	@GetMapping("/category/types")
	public ResponseEntity<?> getPlanCategoryType() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getPlanCategoryTypeList()), HttpStatus.OK);
	}

	@ApiOperation(value = "일정 컬러 조회", notes="일정 컬러 목록을 조회합니다.")
	@GetMapping("/colors")
	public ResponseEntity<?> getPlanColors() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getColorList()), HttpStatus.OK);
	}

	@ApiOperation(value = "일정 알람 방식 목록 조회", notes="일정 알람 방식 목록을 조회합니다.")
	@GetMapping("/alarm/types")
	public ResponseEntity<?> getAlarmTypes() {
		return new ResponseEntity(ApiCommResponse.OK(planService.getAlarmTypeList()), HttpStatus.OK);
	}

}
