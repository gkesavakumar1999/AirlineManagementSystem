package com.example.AirlineManagementSystemV3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BookedSeats")
public class BookedSeats {
	
	public BookedSeats() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sno;
	
	private int flightID;
	private int userId;
	private int seatNo;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public BookedSeats(int userId, int flightID, int seatNo) {
		super();
		this.userId = userId;
		this.flightID = flightID;
		this.seatNo = seatNo;
	}
	
}
