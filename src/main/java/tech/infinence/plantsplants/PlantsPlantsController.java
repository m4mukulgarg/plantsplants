package tech.infinence.plantsplants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tech.infinence.plantsplants.dto.PlantDTO;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"Spring.SpringCore.Code.FieldInjectionWarnings", "SameReturnValue"})
@Controller //Specify how to respond
public class PlantsPlantsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String SPECIMEN_DTO = "specimenDTO";
	private static final String START = "start";
	@Autowired
	private ISpecimenService specimenService;

	@Autowired
	private SpecimenDTO specimenDTO;

	/**
	 * Handles /rb endpoint.
	 *
	 * @param model for SpecimenDTO object
	 * @return specimenDTO in JSON
	 */
	@GetMapping("/rb")
	@ResponseBody
	public SpecimenDTO rBody(Model model) {
		//
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return specimenDTO;
	}

	/**
	 * Handles /editSpecimen endpoint to demonstrate the @RequestParam annotation for post method.
	 * Other attributes for @RequestParam are
	 * required = true/false (true by default)
	 * defaultValue = "" (String value)
	 *
	 * @param model for SpecimenDTO object
	 * @param latitude latitude of the specimen
	 * @param id specimen-id
	 * @return start.html
	 */
	@PostMapping("/edit-specimen")
	public String addPost(Model model, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "id") String id) {
		specimenDTO = specimenService.fetchById();
		specimenDTO.setLatitude(latitude);
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return "/start";
	}

	@GetMapping("/edit-specimen")
	public String add(Model model, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "id") String id) {
		SpecimenDTO specimen = specimenService.fetchById();
		specimen.setLatitude(latitude);
		model.addAttribute(SPECIMEN_DTO, specimen);
		return "/start";
	}

	@GetMapping("/report")
	public String report() {

		return "/report";
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@GetMapping("/start")
	public String read(Model model) {

		log.info("User has entered the /start endpoint");
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return START;
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@GetMapping(value = "/start", params = {"loyalty=blue"})
	public String readBlue() {
		return START;
	}

	/**
	 * Handles the /start endpoint
	 * @return ModelAndView object with START page
	 */
	@GetMapping(value = "/start", params = {"loyalty=silver"})
	public ModelAndView readSilver() {

		specimenDTO.setSpecimenId(34);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(START);
		modelAndView.addObject(SPECIMEN_DTO, specimenDTO);
		return modelAndView;
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@GetMapping(value = "/start", headers = {"Content-Type=text/json"})
	public String readJson() {
		return START;
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */


	@PostMapping("/save-specimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(13);
		return START;
	}

	@ResponseBody
	@PostMapping("/search-specimen")
	public String searchSpecimen(@RequestParam(value = "searchTerm", required = false) String searchTerm, @RequestParam Map paramMap) {

		return "First term: " + searchTerm + "<br/>" +
				"Map:<br/>" +
				paramMap;
	}

	@RequestMapping("/search-plants")
	public ModelAndView searchPlants(@RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm) {
		log.debug("entering search plants");

		List<PlantDTO> plants = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
		try {
			plants = specimenService.fetchPlants(searchTerm + "");
			modelAndView.setViewName("plant-results");
			String msg = "Received 0 results for search string:"+searchTerm;
			if (plants.isEmpty()) log.warn(msg);

		} catch (Exception ioe) {
			log.error("Error happened in searchPlants endpoint", ioe);
			modelAndView.setViewName("error");
		}

		modelAndView.addObject("plants", plants);
		log.debug("exiting search Plants");

		return modelAndView;
	}

	@PostMapping("/start")
	public void create(Model model) {
		index(model);
	}
	/**
	 * Handles the / endpoint
	 * @return the 'start' page
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return START;
	}
}
