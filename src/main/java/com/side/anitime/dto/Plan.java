package com.side.anitime.dto;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

public class Plan {

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

}
