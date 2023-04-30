package com.bus.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bus")
public class Bus {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="bus_no",nullable=false, unique = true)
    private String busNo;
    
    @Column(name="bus_name",nullable=false)
    private String busName;
    
    @Column(name="from_city",nullable=false)
    private String fromCity;
    
    @Column(name="to_city",nullable=false)
    private String toCity;

	 @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	 @Column(name="created_DateTime",nullable=false)
	 private LocalDateTime createdDateTime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="journey_date",nullable=false)
    private LocalDate journeyDate;
    
    @Column(name="travel_duration",nullable=false)
    private Integer travelDuration;
    
    @Column(name="ticket_price",nullable=false)
    private Double ticketPrice;
    
    @Column(name="total_seats",nullable=false)
    private Integer totalSeats;
    
    @Column(name="available_seats",nullable=false)
    private Integer availableSeats;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="bus")
    private Set<Driver> driver;

	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="addedBy_UserId",referencedColumnName="user_id", nullable=false)
	 private User user;

	    @OneToMany(fetch=FetchType.LAZY,mappedBy="bus")
	    private Set<Passenger> passenger;
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	
	public Integer getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(Integer travelDuration) {
		this.travelDuration = travelDuration;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    
	
	 public Bus() {
			super();
			// TODO Auto-generated constructor stub
		}

	public Set<Driver> getDriver() {
		return driver;
	}

	public void setDriver(Set<Driver> driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Passenger> getPassenger() {
		return passenger;
	}

	

	public Bus(Long id, String busNo, String busName, String fromCity, String toCity, LocalDateTime createdDateTime,
			LocalDate journeyDate, Integer travelDuration, Double ticketPrice,  Integer totalSeats,
			Integer availableSeats, Set<Driver> driver, User user, Set<Passenger> passenger) {
		super();
		this.id = id;
		this.busNo = busNo;
		this.busName = busName;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.createdDateTime = createdDateTime;
		this.journeyDate = journeyDate;
		this.travelDuration = travelDuration;
		this.ticketPrice = ticketPrice;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.driver = driver;
		this.user = user;
		this.passenger = passenger;
	}

	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}
	

}
