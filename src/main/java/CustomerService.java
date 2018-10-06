package com.springmvc.service;
import java.util.List;
import com.springmvc.dao.*;

public interface CustomerService {
	
	public void addCustomer(CustomerLogin customer);
	public Integer addSampleCustomer(String username, String password);
	public void getAllCustomer();

}
