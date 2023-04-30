package com.bus.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="passenger_id",nullable=false, unique = true)
    private String passengerId;
    
    @Column(name="passenger_gender",nullable=false)
    private String passengerGender;
    @Column(name="passenger_firstName",nullable=false)
    private String passengerFirstName;
    @Column(name="passenger_lastName",nullable=false)
    private String passengerLastName;
    @Column(name="passenger_age",nullable=false)
    private Integer passengerAge;
    @Column(name="passenger_count",nullable=false)
    private Integer passengerCount;
    @Column(name="passenger_email",nullable=false)
    private String passengerEmail;
    @Column(name="passenger_address",nullable=false)
    private String passengerAddress;
	
	  @OneToOne(fetch=FetchType.LAZY, mappedBy="passenger") 
	  private Payment payment;

		 @ManyToOne(fetch=FetchType.LAZY)
		 @JoinColumn(name="addedBy_UserId",referencedColumnName="user_id", nullable=false)
		 private User user;
		 
		 @ManyToOne(fetch=FetchType.LAZY)
		 @JoinColumn(name="bus_id",referencedColumnName="id", nullable=false)
		 private Bus bus;

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public Integer getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Passenger(Long id, String passengerId, String passengerGender, String passengerFirstName,
			String passengerLastName, Integer passengerAge, Integer passengerCount, String passengerEmail,
			String passengerAddress, Payment payment, User user, Bus bus) {
		super();
		this.id = id;
		this.passengerId = passengerId;
		this.passengerGender = passengerGender;
		this.passengerFirstName = passengerFirstName;
		this.passengerLastName = passengerLastName;
		this.passengerAge = passengerAge;
		this.passengerCount = passengerCount;
		this.passengerEmail = passengerEmail;
		this.passengerAddress = passengerAddress;
		this.payment = payment;
		this.user = user;
		this.bus = bus;
	}
	
	
	
	
	
	
	
	
	
	
    
    
    
}
