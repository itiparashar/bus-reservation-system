package com.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "driver")
public class Driver {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name="driver_id",nullable=false, unique = true)
    private String driverId;
    
    @Column(name="driver_gender",nullable=false)
    private String driverGender;
    
    @Column(name="driver_firstName",nullable=false)
    private String driverFirstName;
    
    @Column(name="driver_lastName",nullable=false)
    private String driverLastName;
    
    @Column(name="driver_age",nullable=false)
    private String driverAge;
    
    @Transient
    private Long busId;
    
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="bus_id",referencedColumnName="id", nullable=false)
	 private Bus bus;

	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="addedBy_UserId",referencedColumnName="user_id", nullable=false)
	 private User user;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverGender() {
		return driverGender;
	}
	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}
	public String getDriverFirstName() {
		return driverFirstName;
	}
	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}
	public String getDriverLastName() {
		return driverLastName;
	}
	public void setDriverLastName(String driverLastName) {
		this.driverLastName = driverLastName;
	}
	public String getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(String driverAge) {
		this.driverAge = driverAge;
	}


	 public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(Long id, String driverId, String driverGender, String driverFirstName, String driverLastName,
			String driverAge, Long busId, Bus bus, User user) {
		super();
		this.id = id;
		this.driverId = driverId;
		this.driverGender = driverGender;
		this.driverFirstName = driverFirstName;
		this.driverLastName = driverLastName;
		this.driverAge = driverAge;
		this.busId = busId;
		this.bus = bus;
		this.user = user;
	}
		
    
    
}
