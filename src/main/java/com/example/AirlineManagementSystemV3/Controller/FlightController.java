package com.example.AirlineManagementSystemV3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineManagementSystemV3.Service.FlightDetailsService;
import com.example.AirlineManagementSystemV3.entity.Flight;
import com.example.AirlineManagementSystemV3.repository.UserRepo;

/*import com.Application.Entity.Flight;
import com.Application.Service.FlightDetailsService;
*/
@RestController
@RequestMapping("/")
public class FlightController {

	@Autowired
	FlightDetailsService fligthDetailsService;
	@Autowired
	UserRepo userrepo;
	
	@GetMapping("/flights")
	public List<Flight> getFlights(@RequestParam int userid,@RequestParam String source, @RequestParam String destination, @RequestParam String date_of_journey){
		 int useridflag=userrepo.verifyUserID(userid);
		 if(useridflag==1) {
		 System.out.println("userid  is valid");
		 }
		  System.out.println("**** inside flight controller *****");
		  return fligthDetailsService.getAvailableFlights(userid,source, destination, date_of_journey);
		 	 
	}
	
}
