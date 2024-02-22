package com.example.AirlineManagementSystemV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.AirlineManagementSystemV3.entity.User;

//import com.example.AirlineManagementSystemv3.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	//User findByUsername(String username,String password);
	//User findByUserid(int userid);

	//User findByUserid(int userId);
	
	 @Procedure(procedureName ="verifyUsernameandpassword") 
	 int verifyUsernameandpassword(String username,String password);
	
	/*
	 * @Query(value =
	 * "CALL verifyUsernameandpassword(:username,:password,@user_id)", nativeQuery =
	 * true) int verifyUsernameandpassword(String username,String password);
	 */	
	/*
	 * @Query(value = "SELECT @user_id", nativeQuery = true) int getUserid();
	 */

}
