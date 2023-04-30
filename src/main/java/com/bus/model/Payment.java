package com.bus.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "payment")
public class Payment {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="payment_Id",nullable=false)
	 private Long paymentId;
	 
	 @Column(name="payment_mode",nullable=false)
	 private String paymentMode;
	 
	 @Column(name="card_no")
	 private String cardNo;
	 
	 @Column(name="card_holder_name")
	 private String cardHolderName;
	 
	 @Column(name="card_expiryYear")
	 private Integer cardExpiryYear;
	 
	 @Column(name="card_expiryMonth")
	 private Integer cardExpiryMonth;
	 
	 @Column(name="card_cvv")
	 private Integer cardCvv;
	 
	 @Column(name="payment_vpa")
	 private String paymentVPA;
	 
	 @Column(name="payment_status")
	 private Boolean paymentStatus;
	 
	 @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	 @Column(name="payment_DateTime",nullable=false)
	 private LocalDateTime paymentDateTime;
	 
	 
	 @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="passenger_id", referencedColumnName = "id", nullable=false)
	 private Passenger passenger;

	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="addedBy_UserId",referencedColumnName="user_id", nullable=false)
	 private User user;
	 
	 
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

	public Integer getCardExpiryYear() {
		return cardExpiryYear;
	}

	public void setCardExpiryYear(Integer cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}

	public Integer getCardExpiryMonth() {
		return cardExpiryMonth;
	}

	public void setCardExpiryMonth(Integer cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
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

	
	  public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}
	
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public Passenger getPassenger() { return passenger; }
	  
	  public void setPassenger(Passenger passenger) { this.passenger = passenger; }

	  

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long paymentId, String paymentMode, String cardNo, String cardHolderName, Integer cardExpiryYear,
			Integer cardExpiryMonth, Integer cardCvv, String paymentVPA, Boolean paymentStatus,
			LocalDateTime paymentDateTime, Passenger passenger, User user) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.cardExpiryYear = cardExpiryYear;
		this.cardExpiryMonth = cardExpiryMonth;
		this.cardCvv = cardCvv;
		this.paymentVPA = paymentVPA;
		this.paymentStatus = paymentStatus;
		this.paymentDateTime = paymentDateTime;
		this.passenger = passenger;
		this.user = user;
	}

	
	 
	 
	 
	
	
	  
	  
	 
	 
	    
}
