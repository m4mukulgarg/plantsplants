package tech.infinence.plantsplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

import java.util.Map;

@Controller //Specify how to respond
public class PlantsPlantsController {
	private static final String SPECIMEN_DTO = "specimenDTO";
	private static final String START = "start";
	@Autowired
	private ISpecimenService iSpecimenService;

	@Autowired
	SpecimenDTO specimenDTO;
	/**
	 * Handles /rb endpoint.
	 *
	 * @param model
	 * @return specimenDTO in JSON
	 */
	@GetMapping("/rb")
	@ResponseBody
	public SpecimenDTO rBody(Model model) {
		specimenDTO = iSpecimenService.fetchById(43);
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return specimenDTO;
	}

	/**
	 * Handles /editSpecimen endpoint to demonstrate the @RequestParam annotation for post method.
	 * Other attributes for @RequestParam are
	 * required = true/false (true by default)
	 * defaultValue = "" (String value)
	 *
	 * @param model
	 * @param latitude
	 * @param id
	 * @return
	 */
	@PostMapping("/editSpecimen")
	public String addPost(Model model, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "id") String id) {
		specimenDTO = iSpecimenService.fetchById(Integer.parseInt(id));
		specimenDTO.setLatitude(latitude);
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return "/start";
	}

	@GetMapping("/editSpecimen")
	public String add(Model model, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "id") String id) {
		SpecimenDTO specimen = iSpecimenService.fetchById(Integer.parseInt(id));
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

		specimenDTO = iSpecimenService.fetchById(43);
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
		specimenDTO = iSpecimenService.fetchById(43);
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
	@PostMapping("/start")
	public String create(Model model) {
		model.addAttribute(SPECIMEN_DTO, specimenDTO);
		return START;
	}

	@PostMapping("/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(13);
		return START;
	}

	@ResponseBody
	@PostMapping("/searchspecimen")
	public String searchSpecimen(@RequestParam(value = "searchTerm", required = false) String searchTerm, @RequestParam Map paramMap) {

		return "First term: " + searchTerm + "<br/>" +
				"Map:<br/>" +
				paramMap;
	}

	/**
	 * Handles the / endpoint
	 * @return the 'start' page
	 */
	@GetMapping("/")
	public String index() {
		return "start.html";
	}
}
