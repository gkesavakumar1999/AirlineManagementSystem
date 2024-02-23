package com.example.AirlineManagementSystemV3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.AirlineManagementSystemV3.entity.Flight;

//import com.Application.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	List<Flight> findBySourceAndDestination(String source, String destination);
	
	Flight findById(int flightId);
	
	@Procedure(procedureName ="getFlightName") 
	 String getFlightName(int flightID);
	
	@Procedure(procedureName ="getstartTime") 
	String getstartTime(int flightID);
	
	@Procedure(procedureName ="getreachtTime") 
	String getreachtTime(int flightID);

}
