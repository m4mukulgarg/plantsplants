package tech.infinence.plantsplants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tech.infinence.plantsplants.dao.ISpecimenDAO;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecimenServiceTest {

	@MockBean
	private ISpecimenDAO specimenDAO;

	@Autowired
	ISpecimenService specimenService;

	@Autowired
	SpecimenDTO specimen;
	List<PlantDTO> plants = new ArrayList<PlantDTO>();

	@Before
	public void setup() throws Exception {
		SpecimenDTO specimen = new SpecimenDTO();
		specimenService.setSpecimenDAO(specimenDAO);
		Mockito.when(specimenDAO.save(specimen)).thenReturn(true);
		specimenService.setSpecimenDAO(specimenDAO);
	}

	@Test
	public void fetchPlants_validateNoResultsForJunkData() {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();
	}

	@Test
	public void fetchPlants_validateNoResultsForCercis() {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForCercis();
		thenMyPlantDiaryReturnsEasternRedbud();
	}

	private void thenMyPlantDiaryReturnsEasternRedbud() {
		// Auto-generated method stub
		boolean redbudFound = false;
		for (PlantDTO p : plants) {
			if (p.getCommon().contains("Eastern Redbud")) {
				redbudFound = true;
			}
		}
		assertTrue(redbudFound);
	}

	private void whenTheUserSearchesForCercis() {
		// Auto-generated method stub
		plants = specimenService.fetchPlants("Eastern Redbud");
	}

	@Test
	public void saveSpecimen_whenRedbudEntered() {
		givenUserIsLoggedInToMyPlantDiary();
		whenUserSearchesForEasternRedbud();
		whenUserAddsTextDetails();
		thenSpecimenIsSaved();
	}

	private void whenUserSearchesForEasternRedbud() {

		plants = specimenService.fetchPlants("Eastern Redbud");

	}

	private void whenUserAddsTextDetails() {

		PlantDTO plantDTO = plants.get(0);
		specimen.setPlantId(plantDTO.getGuid());
		specimen.setDescription("Moine bootiful specimen");

	}

	private void thenSpecimenIsSaved() {
		try {
			boolean res = specimenService.save(specimen);
			//p asses if control is here
			assertTrue(res);
		} catch (Exception e) {
			//failed if control gets here
			fail();
		}
	}

	private void givenUserIsLoggedInToMyPlantDiary() {
	}

	private void whenTheUserSearchesForJunk() {

		plants = specimenService.fetchPlants("kdlahkshlakh;LSDK;AFLSD;A");

	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned", 0, plants.size());
	}

}
