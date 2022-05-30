package com.side.anitime.controller.pet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.side.anitime.codeconst.AnimalType;
import com.side.anitime.domain.pet.PetKind;
import com.side.anitime.dto.PetDTO;
import com.side.anitime.service.pet.PetService;
import com.side.anitime.util.common.ApiCommResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
@Api(value = "반려동물 API", tags = "반려동물 API")
public class PetController {

	private final PetService petService;

	@ApiOperation(value = "사용자가 등록한 반려동물 조회")
	@GetMapping("/list/{userToken}")
	public ResponseEntity<?> getPetListByUserToken(@RequestParam("userToken") String userToken) {
		return new ResponseEntity(ApiCommResponse.OK(petService.getPetListByUserToken(userToken)), HttpStatus.OK);
	}

	@ApiOperation(value = "반려동물 종 검색")
	@GetMapping("/search/kind/{type}/{kindName}")
	public ResponseEntity<?> registerPet(
			  @RequestParam("type") AnimalType type
			, @RequestParam("kindName") String kindName) {
		
		return new ResponseEntity(ApiCommResponse.OK(
				  petService.getPetKindByPetNameAndType(new PetDTO.KindSearch(kindName, type)))
				, HttpStatus.OK);
	}

//    @ApiOperation(value = "반려동물 조회")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successfully register pet", response = ResponsePetDTO.class
//            )
//    })
//    @PostMapping
//    public ResponseEntity<?> registerPet(@RequestBody RequestPetDTO requestDto) {
//        return ResponseEntity.ok(null);
//    }

//    @ApiOperation(value = "반려동물 조회")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully get pet list", response = ResponsePetDTO.class
//            )
//    })
//  
//
//    @ApiOperation(value = "반려동물 상세 조회")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully get detail pet", response = ResponsePetDTO.class
//            )
//    })
//    @GetMapping("{userId}/{petId}")
//    public ResponseEntity<?> getDetailPet(@PathVariable Long userId, @PathVariable Long petId) {
//        return ResponseEntity.ok(null);
//    }
//
//    @ApiOperation(value = "반려동물 품종 조회")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully get pet kind", response = ResponsePetDTO.class
//            )
//    })
//    @GetMapping("kind/{keyword}")
//    public ResponseEntity<?> getDetailPet(@PathVariable String keyword) {
//        return ResponseEntity.ok(null);
//    }
//
//    @ApiOperation(value = "반려동물 정보 수정")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully update pet information"
//            )
//    })
//    @PutMapping
//    public ResponseEntity<?> updatePet(@PathVariable String keyword) {
//        return ResponseEntity.ok(null);
//    }
//
//    @ApiOperation(value = "반려동물 삭제")
//    @ApiResponses(value = {
//            @ApiResponse(code = 204, message = "Successfully delete pet"
//            )
//    })
//    @DeleteMapping("delete/{userId}/{petId}")
//    public ResponseEntity<?> deletePet(@PathVariable Long userId, @PathVariable Long petId) {
//        return ResponseEntity.noContent().build();
//    }
}
