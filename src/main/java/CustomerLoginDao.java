package com.springmvc.dao;

import java.util.List;

public interface CustomerLoginDao {

	public void getAllCustomers();
	public Integer addCustomer(String username, String password);
	public void deleteCustomer(int loginid);
	
}

