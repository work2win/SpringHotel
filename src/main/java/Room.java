package com.springmvc.model;

import com.springmvc.model.Boat;

public class Room {
	private int roomnum;
	private String typeOfRoom;
	private int beds;
	private int roomcost;
	private boolean roomstatus;
	//DataBinding from diff class
	private Boat roomBoat;
	
	
	public Room(){}
	
	public Room(String typeOfRoom, int beds, int roomcost, boolean roomstatus){
		this.typeOfRoom = typeOfRoom;
		this.beds = beds;
		this.roomcost = roomcost;
		this.roomstatus = roomstatus;		
	}
	
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public String getTypeOfRoom() {
		return typeOfRoom;
	}
	public void setTypeOfRoom(String typeOfRoom) {
		this.typeOfRoom = typeOfRoom;
	}
	
		
	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(int roomcost) {
		this.roomcost = roomcost;
	}
	public boolean isRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(boolean roomstatus) {
		this.roomstatus = roomstatus;
	}

	public Boat getRoomBoat() {
		return roomBoat;
	}

	public void setRoomBoat(Boat roomBoat) {
		this.roomBoat = roomBoat;
	}
	
	
	

}
