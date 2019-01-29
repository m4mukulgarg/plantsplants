package tech.infinence.plantsplants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.service.SpecimenServiceStub;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecimenServiceTest {

	@Autowired
	public SpecimenServiceStub specimenServiceStub;

	public List<PlantDTO> plants = new ArrayList<PlantDTO>();

	@Test
	public void fetchPlants_validateNoResultsForJunkData() {
		givenUserIsLoggedInToMyPlantDiary();
		whenTheUserSearchesForJunk();
		thenMyPlantDiaryReturnsZeroResults();
	}

	private void givenUserIsLoggedInToMyPlantDiary() {
	}

	private void whenTheUserSearchesForJunk() {

		plants = specimenServiceStub.fetchPlants("kdlahkshlakh;LSDK;AFLSD;A");

	}

	private void thenMyPlantDiaryReturnsZeroResults() {
		assertEquals("Number of plants returned", 0, plants.size());
	}

}
