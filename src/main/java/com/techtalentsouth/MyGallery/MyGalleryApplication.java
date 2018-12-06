package com.techtalentsouth.MyGallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class MyGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyGalleryApplication.class, args);
	}
}

class Greeting {

    private String content;
    
    public Greeting(String content){
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
}

@Controller
class IndexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        Greeting greeting = new Greeting("Thymeleaf Test Message");
        model.addAttribute("greeting", greeting);
        return "index";
    }
    
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model){
        Greeting greeting = new Greeting("Thymeleaf Test Message");
        model.addAttribute("greeting", greeting);
        return "About-us";
    }
}
