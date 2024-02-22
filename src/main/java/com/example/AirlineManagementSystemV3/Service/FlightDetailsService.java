package com.example.AirlineManagementSystemV3.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AirlineManagementSystemV3.entity.BookedSeats;
import com.example.AirlineManagementSystemV3.entity.Flight;
import com.example.AirlineManagementSystemV3.repository.BookedSeatsRepo;
import com.example.AirlineManagementSystemV3.repository.FlightRepository;

import java.util.Random;

/*import com.Application.Entity.Flight;
import com.Application.Repository.FlightRepository;
*/
import java.util.Scanner;
//import com.demo.PassengersDetails;
//import com.demo.Seat;

@Service
public class FlightDetailsService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	BookedSeatsRepo bookedSeatsRepo;
	// Seat seat = new Seat();
	// PassengersDetails ps = new PassengersDetails();

	static boolean validDate = false;
	Scanner scanner = new Scanner(System.in);

	public List<Flight> getAvailableFlights(String source, String destination, String dateofjourney) {
		System.out.println("***inside flight details service****");

		String dayofweek = getDay(dateofjourney);

		List<Flight> availableFlights = flightRepository.findBySourceAndDestination(source, destination);

		if (validDate && availableFlights != null) {
			System.out.println("Available Flights:");
			System.out.println("Flight Name |  Flight ID   |  Departure Time   |  Arraival Time   | Available Seats |");
			System.out.println("*************************************************************************************");
			availableFlights.stream()
					.filter(flight -> flight.getDayOfWeek() != null && flight.getDayOfWeek().contains(dayofweek))
					.forEach(flight -> {
						System.out.println(flight.getFlightName() + "            " + flight.getFlightId() + "        "
								+ flight.getTimeToDeparture() + "               " + flight.getTimeToReach()+"                  "+flight.getAvailableSeats());
						System.out.println("-----------------------------------------------------------------------------------");
					});
			System.out.println("Do you want to book tickets? (yes/no)");

			String choice = scanner.nextLine().toLowerCase();

			if (choice.equals("yes")) {
				//flight ID and number of seats to book
				System.out.println("Enter flight ID:");
				int flightId = scanner.nextInt();
				System.out.println("Enter number of seat(s):");
				int numSeats = scanner.nextInt();

				boolean booked = bookSeats(flightId, numSeats);
				if (booked) {
					System.out.println("Tickets booked successfully!");
				} else {
					System.out.println("Failed to book tickets. Please try again.");
				}
			} else {
				System.out.println("No tickets booked.");
			}

		} else {
			System.out.println("No Flights available");
		}
		return availableFlights;

	}

	public static String getDay(String dateofjourney) {
		String dayofweek = null;
		LocalDate today = LocalDate.now();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		// Format today's date using a specific pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// String formattedDate = today.format(formatter);
		// System.out.println(formattedDate);
		Date userdate;

		try {
			userdate = sd.parse(dateofjourney);
			LocalDate userDate = LocalDate.parse(dateofjourney, formatter);
			// Compare today's date with the user-entered date
			if (today.isBefore(userDate) || today.isEqual(userDate)) {
				validDate = true;
				Calendar c = Calendar.getInstance();
				c.setTime(userdate);
				dayofweek = new SimpleDateFormat("EE").format(userdate);
			} else {
				System.out.println("Invalid Date");
			}
		} catch (DateTimeParseException | ParseException e) {
			System.out.println("Invalid date format. Please enter the date in the format dd/mm/yyyy.");
			System.exit(0);
		}
		return dayofweek;

	}

	public boolean bookSeats(int flightId, int numSeats) {
		Flight flight = flightRepository.findById(flightId);
		if (flight != null) {
			int availableSeats = flight.getAvailableSeats();
			if (availableSeats >= numSeats) {
				List<Integer> bookedSeatNumbers = generateRandomSeatNumbers(numSeats, availableSeats);
                for (int seatNumber : bookedSeatNumbers) {
                    //flight.addBookedSeat(seatNumber);
                	
                	System.out.println("SeatNo:"+seatNumber);/****booked seat number***/
                	BookedSeats bookedseats=new BookedSeats();
                	bookedseats.setFlightID(flightId);
                	bookedseats.setSeatNo(seatNumber);
                	bookedseats.setUserId(1);
                	bookedSeatsRepo.save(bookedseats);
                	
                }
				flight.setAvailableSeats(availableSeats - numSeats);
				flightRepository.save(flight);
				System.out.println(numSeats + " seat(s) booked successfully for flight " + flightId);
				return true;
			} else {
				System.out.println("Not enough available seat(s) for flight " + flightId);
			}
		} else {
			System.out.println("Flight with ID " + flightId + " not found");
		}
		return false;
	}
	
	public List<Integer> generateRandomSeatNumbers(int numSeats, int totalAvailableSeats) {
        List<Integer> bookedSeatNumbers = new ArrayList<>();
        Random random = new Random();
        while (bookedSeatNumbers.size() < numSeats) {
            int seatNumber = random.nextInt(totalAvailableSeats) + 1;
            if (!bookedSeatNumbers.contains(seatNumber)) {
                bookedSeatNumbers.add(seatNumber);
            }
        }
        return bookedSeatNumbers;
    }
	
}
