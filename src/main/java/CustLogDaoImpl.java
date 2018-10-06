package com.springmvc.dao;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author simu
 *
 */
public class CustLogDaoImpl {
	private static SessionFactory factory;
	
	public static void main(String args[]){
		
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			factory = con.buildSessionFactory();
	        
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		CustLogDaoImpl obj = new CustLogDaoImpl();
		Integer custID1 = obj.addCustomer("simi","pwd");
		Integer custID2 = obj.addCustomer("sumi","pwd1");
		Integer custID3 = obj.addCustomer("sami","pwd2");
		obj.getAllCustomers();
		Boat ob = new Boat();
		Integer boatID1 = obj.addBoat("shikar", 200);
		Room ro = new Room();
		Integer roomID1 = obj.addRoom("nonac", 2, 550, true);
	}
	
	public Integer addCustomer(String username , String password){
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
	
	public Integer addBoat(String boatType , int costOfBoat){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer custID = null;
		try{
			tx = session.beginTransaction();
			Boat b = new Boat(boatType,costOfBoat);
			b.setBoatType(boatType);
			b.setBoatCost(costOfBoat);
			custID = (Integer) session.save(b);
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}finally{
			session.close();
		}
		
		return custID;
	}
	
	public Integer addRoom(String RoomType , int BedNo, int roomCost, boolean status){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer custID = null;
		try{
			tx = session.beginTransaction();
			//Boat b = new Boat(boatType,costOfBoat);
			Room ro = new Room(RoomType, BedNo, roomCost,status);
			ro.setTypeOfRoom(RoomType);
			ro.setNumofBeds(BedNo);
			ro.setRoomcost(roomCost);
			ro.setRoomstatus(status);
			
			custID = (Integer) session.save(ro);
			tx.commit();
			
		}catch(HibernateException e){
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}finally{
			session.close();
		}
		
		return custID;
	}
	
	public void getAllCustomers(){
		Session session = factory.openSession();
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
		
		
	}
	//Create a customer in myhotel.login DB
	public void addCustomer(int loginid, String password){}
	
	//delete a customer from myhotel.login DB
	public void deleteCustomer(int loginid){}

}
