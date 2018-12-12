package com.techtalentsouth.MyGallery.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
		
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("User/index.html");
		
		return mv;
	}
	
	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("User/about-us.html");
		
		return mv;
	}
	
	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("User/contact.html");
		
		return mv;
	}
	
	@GetMapping("/user")
	public ModelAndView user(User user) {
		ModelAndView mv = new ModelAndView("User/user-main.html");
		mv.addObject("users", userRepository.findAll());
		
		return mv;
	}
	
	@PostMapping(value="/user")
	public ModelAndView addNewUser(User user, Model model) {
		userRepository.save(user);
		ModelAndView mv = new ModelAndView("User/user-main");
		mv.addObject("users", userRepository.findAll());
		
		return mv;
	}
	
}
