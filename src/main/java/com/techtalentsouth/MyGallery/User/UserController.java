package com.techtalentsouth.MyGallery.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
		
	@GetMapping("/")
	public String index() {
		return "User/index.html";
	}
	
	@GetMapping("/about")
	public String about() {
		return "User/about-us.html";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "User/contact.html";
	}
	
	@GetMapping("/user")
	public String user(User user, Model model) {
		model.addAttribute("users", userRepository.findAll());
		
		return "User/user-main.html";
	}
	
	@PostMapping(value="/user")
	public String addNewUser(User user, Model model) {
		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		
		return "User/user-main";
	}
	
}
