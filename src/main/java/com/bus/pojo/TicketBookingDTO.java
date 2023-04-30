package com.bus.pojo;

import java.time.LocalDate;

import javax.persistence.Column;

public class TicketBookingDTO {

	private Long selectedBusId;
	
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerId;
	private Integer passengerCount;
	private Integer passengerAge;
	private String passengerAddress;
	private String passengerGender;
	
	
     private Long paymentId;
	 private String paymentMode;
	 private String cardNo;
	 private String cardHolderName;
	 private Integer cardExpiryYear;
	 private Integer cardExpiryMonth;
	 private Integer cardCvv;
	 private String paymentVPA;
	 
	 private String busNo;
	 
    private String busName;
    
    private String fromCity;
    
    private String toCity;
    private Integer travelDuration;
    
    private Double ticketPrice;
    private LocalDate journeyDate;
	
	public Long getSelectedBusId() {
		return selectedBusId;
	}
	public void setSelectedBusId(Long selectedBusId) {
		this.selectedBusId = selectedBusId;
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
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public Integer getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public Integer getCardExpiryMonth() {
		return cardExpiryMonth;
	}
	public void setCardExpiryMonth(Integer cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
	}
	
	public Integer getCardExpiryYear() {
		return cardExpiryYear;
	}
	public void setCardExpiryYear(Integer cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}
	public Integer getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(Integer cardCvv) {
		this.cardCvv = cardCvv;
	}
	public String getPaymentVPA() {
		return paymentVPA;
	}
	public void setPaymentVPA(String paymentVPA) {
		this.paymentVPA = paymentVPA;
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
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	
	
	
}
