package com.example.AirlineManagementSystemV3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AirlineManagementSystemV3.entity.BookedSeats;
import com.example.AirlineManagementSystemV3.entity.Flight;

public interface BookedSeatsRepo extends JpaRepository<BookedSeats, Integer>{

}
