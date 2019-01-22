package tech.infinence.plantsplants;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //Specify how to respond
public class PlantsPlantsController {

	/**
	 * Handles the /start endpoint
	 * @return
	 */
	@RequestMapping(value = "/start", method=RequestMethod.GET)
	public String read() {
		return "start"; 
	}
	
	/**
	 * Handles the /start endpoint
	 * @return
	 */
	@RequestMapping(value = "/start", method=RequestMethod.GET, params= {"loyalty=blue"})
	public String readBlue() {
		return "start"; 
	}
	
	/**
	 * Handles the /start endpoint
	 * @return
	 */
	@RequestMapping(value = "/start", method=RequestMethod.GET, params= {"loyalty=silver"})
	public String readSilver() {
		return "start"; 
	}

	/**
	 * Handles the /start endpoint
	 * @return
	 */
	@RequestMapping(value = "/start", method=RequestMethod.GET, headers= {"Content-Type=text/json"})
	public String readJson() {
		return "start"; 
	}

	/**
	 * Handles the /start endpoint
	 * @return
	 */
	@PostMapping("/start")
	public String create() {
		return "start";
	}

	
	/**
	 * Handles the / endpoint
	 * @return
	 */
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "start"; 
	}
}
