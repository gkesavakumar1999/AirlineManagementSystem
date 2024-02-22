package com.example.AirlineManagementSystemV3.entity;

/*import javax.persistence.Entity;
import javax.persistence.Id;
*/
import java.util.*;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Flight {

	public Flight() {
		
	}
	    @Id
	    
	    private int flightId;
	    
	    private String flightName;
	    
	    private String source;
	    
	    private String destination;
	    
	    private String dayOfWeek;
	    
	    private String timeToDeparture;
	    
	    private String timeToReach;
	    
	    private int availableSeats;
	    
		/*
		 * private List<Integer> bookedSeats = new ArrayList<>();
		 * 
		 * public void addBookedSeat(int seatNumber) { bookedSeats.add(seatNumber); }
		 * 
		 * public List<Integer> getBookedSeats() { return bookedSeats; }
		 */	    
	    
	    public int getFlightId() {
			return flightId;
		}

		public void setFlightId(int flightId) {
			this.flightId = flightId;
		}

		public String getFlightName() {
			return flightName;
		}

		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		

		public String getDayOfWeek() {
			return dayOfWeek;
		}

		public void setDayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}

		public String getTimeToDeparture() {
			return timeToDeparture;
		}

		public void setTimeToDeparture(String timeToDeparture) {
			this.timeToDeparture = timeToDeparture;
		}

		public String getTimeToReach() {
			return timeToReach;
		}

		public void setTimeToReach(String timeToReach) {
			this.timeToReach = timeToReach;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(int availableSeats) {
			this.availableSeats = availableSeats;
		}
		
}
