package tech.infinence.plantsplants.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.PlantList;

import java.io.IOException;
import java.util.List;

@Component
public class PlantDAO implements IPlantDAO {

	@Autowired
	private NetworkDAO networkDAO;

	@Override
	public List<PlantDTO> fetch(String searchFilter) throws IOException {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://plantplaces.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		GetPlants getPlants = retrofit.create(GetPlants.class);
		Call<PlantList> allPlants = getPlants.getAllPlants(searchFilter);
		Response<PlantList> execute = allPlants.execute();
		PlantList plantList = execute.body();

		return plantList.getPlants();
	}

}
