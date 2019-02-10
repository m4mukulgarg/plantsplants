package tech.infinence.plantsplants.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.SpecimenDTO;

@Component
public class SpecimenDAO implements ISpecimenDAO {
	@Autowired
	SpecimenRepository specimenRepository;

	/**
	 * saves the Specimen DTO to the persistence layer
	 *
	 * @param specimenDTO
	 * @return true if successful
	 * @throws Exception
	 */
	@Override
	public boolean save(SpecimenDTO specimenDTO) {
		specimenRepository.save(specimenDTO);
		return false;
	}

	@Override
	public Iterable<SpecimenDTO> fetchAll() {
		return specimenRepository.findAll();
	}
}
