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
	public String index(User user) {
		return "User/index.html";
	}
	
	@GetMapping("/user")
	public String user(User user) {
		return "User/user-main.html";
	}
	
	@PostMapping(value="/")
	public String addNewUser(User user, Model model) {
		userRepository.save(user);
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("email", user.getEmail());
		
		return "User/user-result";
	}
	
}
