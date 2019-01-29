package tech.infinence.plantsplants.service;

import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;

import java.util.List;

/**
 * CRUD operations for specimens
 *
 * @author @m4mukulgarg
 */
public interface ISpecimenService {

	/**
	 * Get specimens from persistence layer.
	 *
	 * @param id a unique lookup
	 * @return a specimen with matching id
	 */
	SpecimenDTO fetchById(int id);

	/**
	 * Persist the given DTO
	 *
	 * @param specimenDTO
	 */
	void save(SpecimenDTO specimenDTO);

	List<PlantDTO> fetchPlants(String s);
}
