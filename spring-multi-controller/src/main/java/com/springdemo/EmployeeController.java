package com.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@RequestMapping(value = "sayWelcome",method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("message", "Welcome to Employee Page.");
		return "employee";
	}
}