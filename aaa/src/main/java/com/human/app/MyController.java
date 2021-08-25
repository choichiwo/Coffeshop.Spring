package com.human.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@RequestMapping("/1")
	public String 메소드이름( Model model) {		
		model.addAttribute("mobile", "2134556");		
		return "contanas";  //home    .jsp생략
	}
}
