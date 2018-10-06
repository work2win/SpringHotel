package com.springmvc.service;
import java.util.List;

import com.springmvc.dao.*;
 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CustomerServiceImpl implements CustomerService {
	
	private static SessionFactory factory;
	
	public void addCustomer(CustomerLogin customer){
		String username = "default_user";
		String password = "Default_pwd";
		
		CustomerServiceImpl cust = new CustomerServiceImpl();
		username = customer.getUname();
		password = customer.getPwd();
		cust.configMethod();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer custID = null;
		try{
			tx = session.beginTransaction();
			CustomerLogin cl = new CustomerLogin(username,password);
			cl.setUname(username);
			cl.setPwd(password);
			custID = (Integer) session.save(cl);
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		
	}
	
	public Integer addSampleCustomer(String username, String password){
		CustomerServiceImpl cust = new CustomerServiceImpl();
		cust.configMethod();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer custID = null;
		try{
			tx = session.beginTransaction();
			CustomerLogin cl = new CustomerLogin(username,password);
			cl.setUname(username);
			cl.setPwd(password);
			custID = (Integer) session.save(cl);
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}finally{
			session.close();
		}
		
		return custID;
	}
	public void getAllCustomer(){
		
		CustomerServiceImpl custum = new CustomerServiceImpl();
		custum.configMethod();
		System.out.println("going to call session");
		Session session = factory.openSession();
		System.out.println("session opened");
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			 List customers = session.createQuery("FROM CustomerLogin").list(); 
	         for (Iterator iterator = customers.iterator(); iterator.hasNext();){
	            CustomerLogin cust = (CustomerLogin) iterator.next(); 
	            System.out.println(cust.getUname());
	            System.out.println(cust.getPwd());
	             
	         }
	         tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}finally{
			session.close();
		}
		
		System.out.println("add user complete");
	}
	
	public void configMethod(){
		
		System.out.println("config method called");
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			factory = con.buildSessionFactory();
	        
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
		System.out.println("config enabled");
		
	}

}
