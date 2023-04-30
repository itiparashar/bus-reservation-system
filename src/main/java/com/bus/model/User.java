package com.bus.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_type",nullable=false)
    private String userType;
    @Column(name="first_name",nullable=false)
    private String firstName;
    @Column(name="last_name",nullable=false)
    private String lastName;
    @Column(name="email",nullable=false, unique = true)
    private String email;
    @Column(name="password",nullable=false)
    private String password;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
    private Set<Payment> payment;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
    private Set<Passenger> passenger;

    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
    private Set<Bus> bus;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="user")
    private Set<Driver> driver;
    
    //getter setters
    
    
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	public Set<Payment> getPayment() {
		return payment;
	}
	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}
	
	
	
	public Set<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}
	public Set<Bus> getBus() {
		return bus;
	}
	public void setBus(Set<Bus> bus) {
		this.bus = bus;
	}
	public Set<Driver> getDriver() {
		return driver;
	}
	public void setDriver(Set<Driver> driver) {
		this.driver = driver;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String userType, String firstName, String lastName, String email, String password,
			Set<Payment> payment, Set<Passenger> passenger, Set<Bus> bus, Set<Driver> driver) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.payment = payment;
		this.passenger = passenger;
		this.bus = bus;
		this.driver = driver;
	}
	
	

}