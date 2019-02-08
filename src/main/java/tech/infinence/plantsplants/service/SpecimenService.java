package tech.infinence.plantsplants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dao.IPlantDAO;
import tech.infinence.plantsplants.dao.ISpecimenDAO;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;

import java.io.IOException;
import java.util.List;

@Component
public class SpecimenService implements ISpecimenService {

	@Autowired
	IPlantDAO plantDAO;

	@Autowired
	ISpecimenDAO specimenDAO;

	@Override
	public ISpecimenDAO getSpecimenDAO() {
		return null;
	}

	@Override
	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		//not needed
	}

	@Override
	public SpecimenDTO fetchById(int id) {
		return null;
	}

	@Override
	public boolean save(SpecimenDTO specimenDTO) {
		specimenDAO.save(specimenDTO);

		return false;
	}

	@Override
	public List<PlantDTO> fetchPlants(String searchTerm) throws IOException {
		return plantDAO.fetch(searchTerm);
	}
}
