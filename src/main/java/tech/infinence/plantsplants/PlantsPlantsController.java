package tech.infinence.plantsplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

@Controller //Specify how to respond
public class PlantsPlantsController {
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
		SpecimenDTO specimenDTO = iSpecimenService.fetchById(43);
		model.addAttribute("specimenDTO", specimenDTO);
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
		SpecimenDTO specimenDTO = iSpecimenService.fetchById(Integer.parseInt(id));
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "/start";
	}

	@GetMapping("/editSpecimen")
	public String add(Model model, @RequestParam(value = "latitude") String latitude, @RequestParam(value = "id") String id) {
		SpecimenDTO specimenDTO = iSpecimenService.fetchById(Integer.parseInt(id));
		specimenDTO.setLatitude(latitude);
		model.addAttribute("specimenDTO", specimenDTO);
		return "/start";
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET)
    public String read(Model model) {

		SpecimenDTO specimenDTO = iSpecimenService.fetchById(43);
        model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=blue"})
	public String readBlue() {
		return "start";
	}

	/**
	 * Handles the /start endpoint
	 * @return ModelAndView object with "start" page
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET, params = {"loyalty=silver"})
	public ModelAndView readSilver() {
		SpecimenDTO specimenDTO = iSpecimenService.fetchById(43);
		specimenDTO.setSpecimenId(34);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("start");
		modelAndView.addObject("specimenDTO", specimenDTO);
		return modelAndView;
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@RequestMapping(value = "/start", method = RequestMethod.GET, headers = {"Content-Type=text/json"})
	public String readJson() {
		return "start";
	}

	/**
	 * Handles the /start endpoint
	 * @return the 'start' page
	 */
	@PostMapping("/start")
	public String create(Model model) {
		model.addAttribute("specimenDTO", specimenDTO);
		return "start";
	}

	@PostMapping("/savespecimen")
	public String saveSpecimen(SpecimenDTO specimenDTO) {
		specimenDTO.setPlantId(13);
		return "start";
	}

	/**
	 * Handles the / endpoint
	 * @return the 'start' page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "start.html";
	}
}
