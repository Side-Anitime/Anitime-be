package com.side.anitime.service.pet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.pet.Pet;
import com.side.anitime.repository.pet.PetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepository;

	public List<Pet> getPetListByUserToken(String userToken) {
		try {
			return petRepository.findPetListByUserToken(userToken);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}

}
