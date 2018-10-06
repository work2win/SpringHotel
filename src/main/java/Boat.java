package com.springmvc.model;

public class Boat {
	private int id;
	private String boatType;
	private int boatCost;
	
	
	public Boat(){}
	
	public Boat(String boatType, int boatCost){
		this.boatType = boatType;
		this.boatCost = boatCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public int getBoatCost() {
		return boatCost;
	}

	public void setBoatCost(int boatCost) {
		this.boatCost = boatCost;
	}
	
	
	
}

