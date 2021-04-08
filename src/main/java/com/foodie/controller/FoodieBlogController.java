package com.foodie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodieBlogController {
	
	//To display the home page of the app
	
	@GetMapping(value = { "/home", "index.html"})
	public ModelAndView	Welcome() {
		ModelAndView mv = new ModelAndView("welcome-page");
		return mv;
	}
}
