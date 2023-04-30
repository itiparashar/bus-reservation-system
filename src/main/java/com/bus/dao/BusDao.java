 package com.bus.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.model.Bus;
import com.bus.model.Driver;
import com.bus.model.Passenger;
import com.bus.model.Payment;
import com.bus.model.User;
import com.bus.pojo.TicketBookingDTO;


public interface BusDao{
	
    Bus findByBusId(Long id);

    List<Bus> findAllBus();
    
    public String deleteBusDtl(long busId);
    
    public Bus addBusDtl(Bus bus);
    
    public Passenger addPassengerDtl(Passenger passenger);
    
    public Payment addPaymentDtl(Payment payment);
    
    public int updateAvailableSeats(Long busId, Integer availableSeats);

	Driver addDriverDetail(Driver driver);

	public List<Passenger> getTicketBookingDetails(Long userId);

	List<Driver> findDriverByBusId(Long busId);

	List<Bus> getAvailableBusDetail();
    
}