package tech.infinence.plantsplants.dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.PlantDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlantDAO implements IPlantDAO {

	@Autowired
	private NetworkDAO networkDAO;

	@Override
	public List<PlantDTO> fetch(String searchFilter) throws IOException, JSONException {
		List<PlantDTO> allPlants = new ArrayList<>();
		String rawJSON = networkDAO.request("https://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=" + searchFilter);
		JSONObject root = new JSONObject(rawJSON);

		JSONArray plants = root.getJSONArray("plants");

		for (int i = 0; i < plants.length(); i++) {
			//JSON data
			JSONObject jsonPlant = plants.getJSONObject(i);

			//Plant object that will populated from JSON data
			PlantDTO plantDTO = new PlantDTO();
			plantDTO.setGuid(jsonPlant.getInt("id"));
			plantDTO.setGenus(jsonPlant.getString("genus"));
			plantDTO.setSpecies(jsonPlant.getString("species"));
			plantDTO.setCultivar(jsonPlant.getString("cultivar"));
			plantDTO.setCommon(jsonPlant.getString("common"));

			//add to collection
			allPlants.add(plantDTO);
		}

		return allPlants;
	}

}
