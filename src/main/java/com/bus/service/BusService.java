package com.bus.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bus.model.Bus;
import com.bus.model.Driver;
import com.bus.model.Passenger;
import com.bus.pojo.TicketBookingDTO;


public interface BusService {

	public List<Bus> busDetail();
	
	public Bus addBusDetail(Bus bus);
	
	public String deleteBus(Long id);

	public Long payBookTicket(TicketBookingDTO ticketBookingDTO, HttpSession session);

	public List<Passenger> getTicketBookingDetailList(Long userId);

	public Driver addDriverDetail(Driver driver);

	public List<Driver> driverDetail(Long busId);

	public List<Bus> getAvailableBusDetail();
	
}
