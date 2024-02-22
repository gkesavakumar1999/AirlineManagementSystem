package com.example.AirlineManagementSystemV3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Userdetails")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
    private String username;
    private String password;
    private String gender;
    
    public User(int userId, String username, String password, String gender) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }
    
    public User()
    {
    	super();
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getGender()
    {
    	return gender;
    }
    
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User: " + username;
    }


}
