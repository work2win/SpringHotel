package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Contact;
import com.jwt.model.Employee;
import com.jwt.model.Movie;

import java.io.IOException;
import java.util.*;
import com.jwt.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "sayWelcome",method = RequestMethod.GET)
	  public String list(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "traveller";
	  }
	
	@RequestMapping(value = "tickets")
	  public ModelAndView tickets(ModelAndView model) throws IOException{
		List<Movie> listMovie = customerService.getAllMovie();
		System.out.println("in controller" +listMovie);
		model.addObject("listMovie", listMovie);
	    model.setViewName("tickets");
	    return model;
	  }
	
	@RequestMapping(value = "booking",method = RequestMethod.GET)
	  public String booking(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "booking";
	  }
	
	@RequestMapping(value = "learn",method = RequestMethod.GET)
	  public String learn(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "learning";
	  }
	
	@RequestMapping(value = "sayAngular",method = RequestMethod.GET)
	  public String viewAngular(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "angular";
	  }
	
	@RequestMapping(value = "about",method = RequestMethod.GET)
	  public String about(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "about";
	  }
	
	@RequestMapping(value = "privacy",method = RequestMethod.GET)
	  public String privacy(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "privacy";
	  }
	
	@RequestMapping(value = "contact",method = RequestMethod.GET)
	  public String contact(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "contact";
	  }
	
	@RequestMapping(value = "saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		
		return new ModelAndView("redirect:angular");
	}
}
