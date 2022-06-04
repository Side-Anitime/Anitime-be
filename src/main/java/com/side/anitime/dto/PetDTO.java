package com.side.anitime.dto;

import java.time.LocalDate;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.codeconst.Gender;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.user.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PetDTO {
	
	@Getter
	@Setter
	public static class SavePetReq {
		
		@ApiModelProperty(				 
				  value = "사용자 식별토큰"
				, name = "userToken"
				, dataType = "String"
				, example = "testtoken")
		private String userToken;
		
		@ApiModelProperty(				 
				  value = "동물 타입(개or고양이)"
				, name = "type"
				, dataType = "String"
				, example = "DOG")
		private AnimalType type;
		
		@ApiModelProperty(				 
				  value = "동물 종"
				, name = "petKindId"
				, dataType = "Integer"
				, example = "1")
		private Long petKindId; //애완 동물 종
		
		@ApiModelProperty(				 
				  value = "반려동물 이름"
				, name = "name"
				, dataType = "String"
				, example = "감자")
		private String name;
		
		@ApiModelProperty(				 
				  value = "성별"
				, name = "gender"
				, dataType = "String"
				, example = "FEMALE")
		private Gender gender; //성별
		
		@ApiModelProperty(				 
				  value = "중성화 여부"
				, name = "neuterYn"
				, dataType = "String"
				, example = "Y")
		private YesNo neuterYn; //중성화 여부
		
		@ApiModelProperty(				 
				  value = "간단한 동물 소개"
				, name = "shortIntroduce"
				, dataType = "String"
				, example = "이 아이는 저의 반료동물입니다.")
		private String shortIntroduce;
		
		@ApiModelProperty(				 
				  value = "생일"
				, name = "birthday"
				, dataType = "String"
				, example = "2022-06-04")
		private LocalDate birthday;
		
		@ApiModelProperty(				 
				  value = "처음 만난 날"
				, name = "firstMeetDate"
				, dataType = "String"
				, example = "2019-06-04")
		private LocalDate firstMeetDate;
		
	}
	

	@Getter
	@Setter
	public static class Info {
		private Long petId;

		private User user;

		private AnimalType type;

		private String kind;

		private String name;

		private LocalDate birthday;

		private String personality;

		private String image;

		private Gender gender;

		private YesNo neuterYn;

		private YesNo representYn;

	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	public static class KindSearch {
		
		private String kindName;

		private AnimalType type;

	}
	
	

}
