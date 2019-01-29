package tech.infinence.plantsplants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tech.infinence.plantsplants.dto.SpecimenDTO;
import tech.infinence.plantsplants.service.ISpecimenService;

@Controller //Specify how to respond
public class PlantsPlantsController {
	@Autowired
	private ISpecimenService iSpecimenService;

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
	public String create() {
		return "start";
	}


	/**
	 * Handles the / endpoint
	 * @return the 'start' page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "start";
	}
}
