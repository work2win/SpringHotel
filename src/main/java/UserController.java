package com.jwt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.jwt.model.User;

/**
import com.jwt.service.UserService;
**/
@Controller
@RequestMapping("myaccount")
public class UserController {
	
	
	@RequestMapping(value = "sayWelcome",method = RequestMethod.GET)
	  public String list(ModelMap model) {
	    model.addAttribute("message", "Welcome to Customer Page.");
	    return "login";
	  }
	
	
	/**
 @Autowired
 private UserService userService;
 
 @RequestMapping(value= {"login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("login");
  return model;
 }
 
 ***/
 @RequestMapping(value= {"signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("signup");
  
  return model;
 }
 
 /**
 
 @RequestMapping(value= {"signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("signup");
  } else {
   userService.saveUser(user);
   model.addObject("msg", "User has been registered successfully!");
   model.addObject("user", new User());
   model.setViewName("signup");
  }
  
  return model;
 }
 
 @RequestMapping(value= {"/user"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
  model.setViewName("user");
  return model;
 }
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }
 
 **/
}