package tech.infinence.plantsplants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecimenServiceTest {

	@Autowired
	ISpecimenService specimenService;
	@Autowired
	SpecimenDTO specimen;
	List<PlantDTO> plants = new ArrayList<PlantDTO>();

	@Test
	public void fetchPlants_validateNoResultsForJunkData() {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();
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
		specimen.setDescription("Moine bootiful spechimen");

	}

	private void thenSpecimenIsSaved() {
		try {
			specimenService.save(specimen);
			//passes if control is here
			assertTrue(true);
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
