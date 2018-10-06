package com.springmvc.controller;

import com.springmvc.dao.CustomerLogin;
import com.springmvc.model.*;
import com.springmvc.service.CustomerService;
import com.springmvc.service.CustomerServiceImpl;
import com.springmvc.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController{

	
public CustomerServiceImpl obj;

@Autowired
public UserService userService;

@RequestMapping(value ="/hotelRoomForm.html" , method = RequestMethod.GET)	
public ModelAndView getHotelRoomForm() {
		
		ModelAndView modelandview = new ModelAndView("HotelRoomForm");
		return modelandview;
	}


@RequestMapping(value ="/submitHotelRoomForm.html", method = RequestMethod.POST)
public ModelAndView submitHotelRoomForm(@ModelAttribute("room") Room room, BindingResult result){
		
	if(result.hasErrors()){
		ModelAndView model = new ModelAndView("HotelRoomForm");
		return model;
	}
	
	ModelAndView model = new ModelAndView("HotelRoomSuccess");
	return model;

}

@RequestMapping(value="/customerlogin",method = RequestMethod.GET)
public ModelAndView getCustomerLogin(HttpServletRequest req, HttpServletResponse res){
	
	ModelAndView modelandview = new ModelAndView("CustomerLogin");
	modelandview.addObject("welcomeMessage","customerlogin request mapping");
	modelandview.addObject("custmerlogin", new CustomerLogin());
	System.out.println("path info"+req.getPathInfo());
	return modelandview;
}

@RequestMapping(value ="/submitCustomerLogin.html", method = RequestMethod.POST)
public ModelAndView submitCustomerLogin(HttpServletRequest req, HttpServletResponse res,
		@ModelAttribute("customerlogin") CustomerLogin cust) {
		
		
	String username= "defaultusername";
	String password = "defaultpwd";
	
	System.out.println(username+password);
	username = cust.getUname();
	password = cust.getPwd();
	System.out.println(username+password);
	obj.addSampleCustomer(username, password);
	ModelAndView modelandview = new ModelAndView("CustomerLogin");
	modelandview.addObject("welcomeMessage","added the customer");
	return modelandview;

}

@RequestMapping(value = "/register", method = RequestMethod.GET)
public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
  ModelAndView mav = new ModelAndView("register");
  mav.addObject("user", new User1());
  return mav;
}

@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
@ModelAttribute("user") User1 user) {
	
userService.register(user);
return new ModelAndView("welcome", "username", user.getUsername());
}


}

