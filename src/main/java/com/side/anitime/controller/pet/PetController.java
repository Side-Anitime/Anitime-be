package com.side.anitime.controller.pet;

import com.side.anitime.domain.pet.Pet;
import com.side.anitime.dto.alarm.ResponseAlarmDto;
import com.side.anitime.dto.pet.RequestPetDto;
import com.side.anitime.dto.pet.ResponsePetDto;
import com.side.anitime.repository.pet.PetRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
@Api(value = "반려동물 API", tags = "반려동물 API")
public class PetController {

    private final PetRepository petRepository;

    @ApiOperation(value = "반려동물 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully register pet", response = ResponsePetDto.class
            )
    })
    @PostMapping
    public ResponseEntity<?> registerPet(@RequestBody RequestPetDto requestDto) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "반려동물 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get pet list", response = ResponsePetDto.class
            )
    })
    @GetMapping("{userId}")
    public ResponseEntity<?> getPetList(@PathVariable Long userId) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "반려동물 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get detail pet", response = ResponsePetDto.class
            )
    })
    @GetMapping("{userId}/{petId}")
    public ResponseEntity<?> getDetailPet(@PathVariable Long userId, @PathVariable Long petId) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "반려동물 품종 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get pet kind", response = ResponsePetDto.class
            )
    })
    @GetMapping("kind/{keyword}")
    public ResponseEntity<?> getDetailPet(@PathVariable String keyword) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "반려동물 정보 수정")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update pet information"
            )
    })
    @PutMapping
    public ResponseEntity<?> updatePet(@PathVariable String keyword) {
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "반려동물 삭제")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully delete pet"
            )
    })
    @DeleteMapping("delete/{userId}/{petId}")
    public ResponseEntity<?> deletePet(@PathVariable Long userId, @PathVariable Long petId) {
        return ResponseEntity.noContent().build();
    }
}
