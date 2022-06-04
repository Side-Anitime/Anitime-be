package com.side.anitime.service.pet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.side.anitime.domain.pet.Pet;
import com.side.anitime.domain.pet.PetKind;
import com.side.anitime.domain.user.User;
import com.side.anitime.dto.PetDTO;
import com.side.anitime.dto.PetDTO.SavePetReq;
import com.side.anitime.repository.pet.PetKindRepository;
import com.side.anitime.repository.pet.PetRepository;
import com.side.anitime.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {

	private final PetRepository petRepository;
	private final PetKindRepository petKindRepository;
	private final UserRepository userRepository;
	
	public void savePetByUser(SavePetReq saveReq) {
		
		Pet savePet = new Pet();
		savePet.setUser(userRepository.findByUserToken(saveReq.getUserToken()) );
		savePet.setType(saveReq.getType());
		
		if(saveReq.getPetKindId() != null && !saveReq.getPetKindId().toString().isEmpty()) {
			PetKind petKind = petKindRepository.findById(saveReq.getPetKindId()).get();
			savePet.setPetKind(petKind);
		}
		
		savePet.setName(saveReq.getName());
		savePet.setGender(saveReq.getGender());
		savePet.setNeuterYn(saveReq.getNeuterYn());
		savePet.setShortIntroduce(saveReq.getShortIntroduce());
		savePet.setBirthday(saveReq.getBirthday());
		savePet.setFirstMeetDate(saveReq.getFirstMeetDate());
		petRepository.save(savePet);
		
	}

	public List<Pet> getPetListByUserToken(String userToken) {
		try {
			return petRepository.findPetListByUserToken(userToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PetKind> getPetKindByPetNameAndType(PetDTO.KindSearch vo) {
		return petKindRepository.findByTypeAndKindNameContains(vo.getType(), vo.getKindName());
	}

	public void deleteByUserTokenAndPetId(String userToken, Long petId) {
		User userDto = userRepository.findByUserToken(userToken);
		petRepository.deleteByUserTokenAndPetId(userDto.getUserId(), petId);
	}

}
