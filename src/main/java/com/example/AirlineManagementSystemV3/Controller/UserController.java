package com.example.AirlineManagementSystemV3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineManagementSystemV3.entity.User;
import com.example.AirlineManagementSystemV3.repository.UserRepo;

//import com.example.AirlineManagementSystemv2.entity.User;
//import com.example.AirlineManagementSystemv2.repository.UserRepo;
//import com.example.AirlineManagementSystemv2.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;
	//UserService userService = new UserService();

	@GetMapping("/hi")
	public String hello() {

		return "Hello, kesava gosala rest is working fine!";

	}

	@PostMapping("/api/saveuser")
	public User saveUserTest(@RequestBody User user) {

		System.out.println("**" + user);
		// userRepo.save(user);
		return user;
		// return new ResponseEntity<>(userRepo.save(user),HttpStatus.CREATED);
	}

	
	
	 @PostMapping("/saveuser") 
	 public User saveUser(@RequestBody User user) {
	 
	  System.out.println("***" + user); userRepo.save(user);
	  return user;
	  // return new ResponseEntity<>(userRepo.save(user),HttpStatus.CREATED);
	  }
	 
	 
	
	/*
	 * @PostMapping("/saveuser") public User saveUser(@RequestBody User user) {
	 * System.out.println("**calling service layer***" + user); User usernew=new
	 * User(); usernew=user; System.out.println(usernew); User
	 * user2=userService.saveUser(user); return user2; }
	 */

	 @GetMapping("/validateuser")	    
	    public String validateUserDetails( @RequestParam String username,@RequestParam String password) {
		 System.out.println("username"+username);
		 System.out.println("password"+password);
		 try {
			 System.out.println("inside try block");
			 System.out.println("calling Repo layer");
			 int userid=userRepo.verifyUsernameandpassword(username,password);
			 System.out.println("***success***");
			if(userid!=0&&userid>=1)
			{
				System.out.println("welcome "+username+" your userid is :"+userid);
				return "user is validated";
				
			}
			
			else
			{
				System.out.println("entered username or password is in correct");
				System.out.println("**please check username or password***");
				return "entered username or password is incorrect";
			}
			
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "entered username or password is incorrect";
		}
	 
	 
}
}
