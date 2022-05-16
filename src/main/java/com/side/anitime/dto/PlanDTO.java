package com.side.anitime.dto;

import javax.validation.constraints.Positive;

import com.google.gson.JsonArray;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PlanDTO {

	@Getter
	@Setter
	public static class SaveReq {
		
		@ApiParam(name="userToken", value = "testtoken")
		private String userToken;
		private String title;
		private String contents;
		private String startDate;
		private String endDate;

		@Positive
		private Long colorId;
		
		@Positive
		private Long planCategoryId;
		
		@Positive
		private Long alarmId;
		
	}
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	@ToString
	public static class CalendarViewReq{
		
		private String year;
		
		private String month;
		
		private String userToken;
		
	}
	
	@Getter
	@Setter
	@ToString
	public static class CalendarViewRes{
		
		private String[] name;//일정 카테고리 명
		
		private JsonArray dots; //일정 색깔 정보 저장
		
	}

}
