package tech.infinence.plantsplants.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "specimen")
@Component
public class SpecimenDTO {
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SpecimenDTO)) return false;
		SpecimenDTO that = (SpecimenDTO) o;
		return getSpecimenId() == that.getSpecimenId();
	}

	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getSpecimenId(), getLatitude(), getLongitude());
	}

	@Id
	@Column(name = "SPECIMEN_ID")
	private int specimenId;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longitude;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PLANT_ID")
	private int plantId;

	@Column(name = "PLANT_NAME")
	private String plantName;


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
				", plantName='" + plantName + '\'' +
				'}';
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

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
