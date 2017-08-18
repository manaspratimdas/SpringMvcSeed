package nee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import nee.model.Request;
import nee.service.NeeService;

@Controller
public class NeeController {

	@Autowired
	NeeService neeService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {

		model.addAttribute("welcome", "Welcome to NEE");
		return "welcome";

	}

	@RequestMapping("/request")
	public ModelAndView myRequest() {
		return new ModelAndView("requestform", "command", new Request());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addRequest(@ModelAttribute("request") Request request,ModelMap model) {
		
		model.addAttribute("name",request.getUsername());
		model.addAttribute("destination", request.getDestination());
		
		neeService.addRequest(request);
		return "processmyrequest";
	}
	
	/*@RequestMapping(value="/locations", method=RequestMethod.GET)
	public ResponseEntity listLocation(){
		
		Location location=new Location();
		location.setName("Guwahati");
		location.setState("Assam");
		location.setPriority("1");
		location.setCost(2000.00);
		
		
		if (location == null) {
			return new ResponseEntity("No location ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(location, HttpStatus.OK);
		
	}*/
}
