package com.springmvc.dao;

//POJO class
public class CustomerLogin {

	private int id;
	private String uname;
	private String pwd;
	
	
	public CustomerLogin(){}

	public CustomerLogin(String uname, String pwd){
		this.uname = uname;
		this.pwd = pwd;
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
		
		
}
