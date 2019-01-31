package tech.infinence.plantsplants.dao;

import tech.infinence.plantsplants.dto.SpecimenDTO;

/**
 * CRUD Operations for tech.infinence.plantsplants.dao.SpecimenDTO
 */
public interface ISpecimenDAO {
	/**
	 * saves the Specimen DTO to the persistence layer
	 *
	 * @param specimenDTO
	 * @return true if successful
	 * @throws Exception
	 */
	boolean save(SpecimenDTO specimenDTO) throws Exception;
}
