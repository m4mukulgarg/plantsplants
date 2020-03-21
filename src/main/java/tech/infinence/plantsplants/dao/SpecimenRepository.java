package tech.infinence.plantsplants.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tech.infinence.plantsplants.dto.SpecimenDTO;
//import OracleDriver

@Component
public interface SpecimenRepository extends CrudRepository<SpecimenDTO, Integer> {

}
