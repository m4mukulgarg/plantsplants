package tech.infinence.plantsplants;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Specify how to respond
public class PlantsPlantsController {
	
	 
	@RequestMapping("/")
	public String start() {
		return "start";  //return src/main/resources/start.html
	}

}
