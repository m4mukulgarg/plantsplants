package tech.infinence.plantsplants.service;

import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) {

		//Stub out a plant fetch mechanism
		List<PlantDTO> matchingPlants = new ArrayList<PlantDTO>();

		if (searchTerm.contains("edbud") || searchTerm.contains("Cercis")) {
			PlantDTO plant = new PlantDTO();
			plant.setCommon("Eastern Redbud");
			plant.setCultivar("");
			plant.setGenus("Cercis");
			plant.setSpecies("canadensis");
			matchingPlants.add(plant);
		}
		return matchingPlants;
	}
}
