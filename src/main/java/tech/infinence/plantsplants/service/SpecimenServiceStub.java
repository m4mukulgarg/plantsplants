package tech.infinence.plantsplants.service;

import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.SpecimenDTO;

@Component
public class SpecimenServiceStub implements ISpecimenService {

	@Override
	public SpecimenDTO fetchById(int id) {
		SpecimenDTO specimenDTO = new SpecimenDTO();
		specimenDTO.setSpecimenId(43);
		return specimenDTO;
	}

	@Override
	public void save(SpecimenDTO specimenDTO) {

	}
}
