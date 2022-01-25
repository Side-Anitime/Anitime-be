package com.side.anitime.controller.pet;

import com.side.anitime.domain.pet.Pet;
import com.side.anitime.dto.pet.ResponsePetDto;
import com.side.anitime.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;

    @GetMapping("{testId}")
    public ResponseEntity<?> getTestList(@PathVariable Long testId) {
        Pet pet = petRepository.findById(testId).orElseThrow(() -> new IllegalStateException("에휴 오류났어~~"));

        return ResponseEntity.ok(
                ResponsePetDto.Detail.builder()
                        .id(pet.getPetId())
                        .name(pet.getName())
                        .gender(pet.getGender())
                        .build()
        );
    }
}
