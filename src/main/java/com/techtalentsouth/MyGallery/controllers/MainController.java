package com.techtalentsouth.MyGallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/about")
	public String about() {
		return "About-us.html";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Contact.html";
	}
	
}
