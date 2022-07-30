package com.side.anitime.dto;

import java.util.List;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PlanDTO {

	@Getter
	@Setter
	public static class SavePlanReq {
		
		@ApiParam(name="userToken", value = "testtoken")
		 String userToken;
		 String title;
		 String contents;
		 String startDate;
		 String endDate;

		@Positive
		 Long colorId;
		
		@Positive
		 Long planCategoryId;
		
		@Positive
		 Long alarmId;
		
		 List<Long> petIds;
		
	}
	
	@Getter
	@Setter
	public static class ModifyPlanReq {
		
		@ApiParam(name="userToken", value = "testtoken")
		 String userToken;
		@Positive
		Long planId;
		
		 String title;
		 String contents;
		 String startDate;
		 String endDate;

		@Positive
		 Long colorId;
		
		@Positive
		 Long planCategoryId;
		
		@Positive
		 Long alarmId;
		
		 List<Long> petIds;
		
	}
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	@ToString
	public static class CalendarViewReq{
		
		 String year;
		
		 String month;
		
		 String userToken;
		
	}
	
	@Getter
	@Setter
	@ToString
	public static class CalendarViewRes{
		
		 String[] name;//일정 카테고리 명
		
		 List<PlanDTO.Color> dots; //일정 색깔 정보 저장
		
	}
	
	@Getter
	@Setter
	@ToString
	public static class Color{
		 String color;
	}

}
