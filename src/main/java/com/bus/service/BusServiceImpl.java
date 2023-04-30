package com.bus.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.dao.BusDao;
import com.bus.dao.UserDao;
import com.bus.model.Bus;
import com.bus.model.Driver;
import com.bus.model.Passenger;
import com.bus.model.Payment;
import com.bus.model.User;
import com.bus.pojo.TicketBookingDTO;

@Service
public class BusServiceImpl implements BusService{

	@Autowired
	BusDao busDao;
	
	@Override
	public List<Bus> busDetail() {
		
		List<Bus> busList=busDao.findAllBus();
		
		return busList;
    }
	@Override
	public Bus addBusDetail(Bus bus) {
		
		Date now = new Date();
		Instant current = now.toInstant();
		LocalDateTime dateTime = LocalDateTime.ofInstant(current, 
                ZoneId.systemDefault());

		bus.setCreatedDateTime(dateTime);

		Bus busDtl=busDao.addBusDtl(bus);
		
		
		return busDtl;
    }
	@Override
	public String deleteBus(Long id) {
		
		String message=busDao.deleteBusDtl(id);
		
		
		return message;
    }
	@Override
	public Long payBookTicket(TicketBookingDTO ticketBookingDTO, HttpSession session) {
		// TODO Auto-generated method stub
		
		User user=(User) session.getAttribute("userDtl");
		Bus bus=busDao.findByBusId(ticketBookingDTO.getSelectedBusId());
		
		//add passenger Detail
		Passenger passenger=new Passenger();
		passenger.setUser(user);
		passenger.setBus(bus);
		passenger.setPassengerId(ticketBookingDTO.getPassengerId());
		passenger.setPassengerFirstName(ticketBookingDTO.getPassengerFirstName());
		passenger.setPassengerLastName(ticketBookingDTO.getPassengerLastName());
		passenger.setPassengerGender(ticketBookingDTO.getPassengerGender());
		passenger.setPassengerAge(ticketBookingDTO.getPassengerAge());
		passenger.setPassengerCount(ticketBookingDTO.getPassengerCount());
		passenger.setPassengerEmail(ticketBookingDTO.getPassengerEmail());
		passenger.setPassengerAddress(ticketBookingDTO.getPassengerAddress());
		
		passenger=busDao.addPassengerDtl(passenger);
		
		if(passenger.getId()!=null) {
			//add payment Detail
			Payment  payment=new Payment();
			payment.setUser(user);
			payment.setPassenger(passenger);
			payment.setPaymentMode(ticketBookingDTO.getPaymentMode());
			payment.setPaymentStatus(true);
			Date now = new Date();
			//SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			//String nowStr=simpleDateFormat.format(now);
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
			Instant current = now.toInstant();
			LocalDateTime dateTime = LocalDateTime.ofInstant(current, 
                    ZoneId.systemDefault());

			payment.setPaymentDateTime(dateTime);
			if(ticketBookingDTO.getPaymentMode().equalsIgnoreCase("debitCard")) {
				payment.setCardNo(ticketBookingDTO.getCardNo());
				payment.setCardHolderName(ticketBookingDTO.getCardHolderName());
				payment.setCardExpiryYear(ticketBookingDTO.getCardExpiryYear());
				payment.setCardExpiryMonth(ticketBookingDTO.getCardExpiryMonth());
				payment.setCardCvv(ticketBookingDTO.getCardCvv());
		}if(ticketBookingDTO.getPaymentMode().equalsIgnoreCase("vpa"))
			{
				payment.setPaymentVPA(ticketBookingDTO.getPaymentVPA());
			}
			
			payment=busDao.addPaymentDtl(payment);
			
			
			//update available seats in bus table
			if(payment.getPaymentId()!=null) {
				
				if(bus!=null) {
					 Integer availableSeats=bus.getAvailableSeats();
					 availableSeats=availableSeats-passenger.getPassengerCount();
					Integer successFlag=busDao.updateAvailableSeats(ticketBookingDTO.getSelectedBusId(), availableSeats);
					
					
					
					//setting this properties to Show On UI after ticket booking
					ticketBookingDTO.setBusNo(bus.getBusNo());
					ticketBookingDTO.setBusName(bus.getBusName());
					ticketBookingDTO.setFromCity(bus.getFromCity());
					ticketBookingDTO.setToCity(bus.getToCity());
					ticketBookingDTO.setTicketPrice(bus.getTicketPrice());
					ticketBookingDTO.setTravelDuration(bus.getTravelDuration());
					ticketBookingDTO.setJourneyDate(bus.getJourneyDate());
					
					if(successFlag>0)
						return passenger.getId();
					else
						return null;
				}else
					return null;
			}else
				return null;
		}else
			return null;
		
	}
	@Override
	public List<Passenger> getTicketBookingDetailList(Long userId) {
		// TODO Auto-generated method stub
		List<Passenger> ticketBookingDTOList=busDao.getTicketBookingDetails(userId);
		return ticketBookingDTOList;
	}
	@Override
	public Driver addDriverDetail(Driver driver) {
		// TODO Auto-generated method stub

		Bus bus=busDao.findByBusId(driver.getBusId());
		driver.setBus(bus);
		Driver driverDtl=busDao.addDriverDetail(driver);
		
		
		return driverDtl;
	}
	@Override
	public List<Driver> driverDetail(Long busId) {
		// TODO Auto-generated method stub
		return busDao.findDriverByBusId(busId);
	}
	@Override
	public List<Bus> getAvailableBusDetail() {
		// TODO Auto-generated method stub
		return busDao.getAvailableBusDetail();
	}
}
