package com.side.anitime.service.pet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.pet.Pet;
import com.side.anitime.domain.pet.PetKind;
import com.side.anitime.dto.PetDTO;
import com.side.anitime.repository.pet.PetKindRepository;
import com.side.anitime.repository.pet.PetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepository;
	private final PetKindRepository petKindRepository;

	public List<Pet> getPetListByUserToken(String userToken) {
		try {
			return petRepository.findPetListByUserToken(userToken);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<PetKind> getPetKindByPetNameAndType(PetDTO.KindSearch vo){
		return petKindRepository.findByTypeAndKindNameContains(vo.getType(), vo.getKindName());
	}

}
