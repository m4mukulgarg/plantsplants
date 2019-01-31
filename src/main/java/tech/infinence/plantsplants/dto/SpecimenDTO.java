package tech.infinence.plantsplants.dto;

import org.springframework.stereotype.Component;

@Component
public class SpecimenDTO {
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SpecimenDTO)) return false;
		SpecimenDTO that = (SpecimenDTO) o;
		return getPlantId() == that.getPlantId();
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "SpecimenDTO{" +
				"specimenId=" + specimenId +
				", latitude='" + latitude + '\'' +
				", longitude='" + longitude + '\'' +
				", description='" + description + '\'' +
				", plantId=" + plantId +
				'}';
	}

	private int specimenId;
	private String latitude;
	private String longitude;
	private String description;
	private int plantId;

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getSpecimenId() {
		return specimenId;
	}

	public void setSpecimenId(int specimenId) {
		this.specimenId = specimenId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
