package com.side.anitime.controller.pet;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.dto.PetDTO;
import com.side.anitime.service.pet.PetService;
import com.side.anitime.util.common.ApiCommResponse;
import com.side.anitime.util.common.ResultCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
@Api(value = "반려동물 API", tags = "반려동물 API")
public class PetController {

	private final PetService petService;
	
	@ApiOperation(value = "반려동물 등록", notes="반려동물을 등록합니다.")
	@PostMapping("/save")
	public ResponseEntity<?> savePet(@Valid @RequestBody PetDTO.SavePetReq saveReq) {
		try {
			petService.savePetByUser(saveReq);
			return new ResponseEntity(ApiCommResponse.OK(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			 return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR), ResultCode.ERROR.getStatus());
		}
		
	}

	@ApiOperation(value = "사용자가 등록한 반려동물 조회", notes="사용자가 등록한 반려동물 목록을 조회합니다.")
	@GetMapping("/list/{userToken}")
	public ResponseEntity<?> getPetListByUserToken(@RequestParam("userToken") String userToken) {
		return new ResponseEntity(ApiCommResponse.OK(petService.getPetListByUserToken(userToken)), HttpStatus.OK);
	}

	@ApiOperation(value = "반려동물 종 검색", notes="사용자의 반려동물은 검색합니다.")
	@GetMapping("/search/kind/{type}/{kindName}")
	public ResponseEntity<?> registerPet(
			  @RequestParam("type") AnimalType type
			, @RequestParam("kindName") String kindName) {
		
		return new ResponseEntity(ApiCommResponse.OK(
				  petService.getPetKindByPetNameAndType(new PetDTO.KindSearch(kindName, type)))
				, HttpStatus.OK);
	}
	
	@ApiOperation(value = "사용자 반려동물 삭제", notes="사용자의 반려동물은 삭제합니다.")
	@RequestMapping(value = "/delete/{userToken}/{petId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserPet(
		  @ApiParam(value = "userToken", required = true) @PathVariable("userToken") String userToken
		, @ApiParam(value = "petId", required = true) @PathVariable("petId") Long petId
			){
    	
		try {
			 petService.deleteByUserTokenAndPetId(userToken, petId);
	    	 return new ResponseEntity(ApiCommResponse.OK(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			 return new ResponseEntity(ApiCommResponse.Error(ResultCode.ERROR), ResultCode.ERROR.getStatus());
		}
    	 
	}

}
