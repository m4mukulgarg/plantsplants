package tech.infinence.plantsplants.service;

import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService {

	@Override
	public SpecimenDTO fetchById(int id) {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(43);
		specimenDTO.setLatitude("39.74");
		specimenDTO.setLongitude("-84.51");
		specimenDTO.setDescription("A bootiful spechimen");
		return specimenDTO;
	}

	@Override
	public void save(SpecimenDTO specimenDTO) {

	}
}
