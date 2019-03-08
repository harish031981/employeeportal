package com.info.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditController {
	
	@RequestMapping("/editskills")
	public String index(Model model) {
		
    	return "editskills";
    }
    
}
