package tech.infinence.plantsplants.service;

import tech.infinence.plantsplants.dao.ISpecimenDAO;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;

import java.io.IOException;
import java.util.List;

/**
 * CRUD operations for specimens
 * @author @m4mukulgarg
 */
public interface ISpecimenService {

	ISpecimenDAO getSpecimenDAO();

	void setSpecimenDAO(ISpecimenDAO specimenDAO);

	SpecimenDTO fetchById();

	boolean save(SpecimenDTO specimenDTO) throws IOException;

	List<PlantDTO> fetchPlants(String searchTerm) throws IOException;
}
