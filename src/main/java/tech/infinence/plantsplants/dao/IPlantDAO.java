package tech.infinence.plantsplants.dao;

import org.json.JSONException;
import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.PlantDTO;

import java.io.IOException;
import java.util.List;

@Component
public interface IPlantDAO {
	List<PlantDTO> fetch(String searchFilter) throws IOException, JSONException;
}
