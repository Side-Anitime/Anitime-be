package com.side.anitime.dto;

import java.time.LocalDate;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.codeconst.Gender;
import com.side.anitime.codeconst.YesNo;
import com.side.anitime.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PetDTO {

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
