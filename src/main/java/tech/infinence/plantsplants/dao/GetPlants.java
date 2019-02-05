package tech.infinence.plantsplants.dao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tech.infinence.plantsplants.dto.PlantList;

public interface GetPlants {
	@GET("/perl/mobile/viewplantsjson.pl")
	Call<PlantList> getAllPlants(@Query("?Combined_Name") String combinedName);
}
