package com.bus.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bus.model.Bus;
import com.bus.model.Driver;
import com.bus.model.Passenger;
import com.bus.model.Payment;

@Repository
public class BusDaoImpl implements BusDao{

	//dependency : javax.persistence.EntityManager : i/f : equivalent to org.hibernate.Session
		@PersistenceContext //JPA anno.
		private EntityManager entityManager;
		
		
		@Autowired
		private SessionFactory sessionFactory;
		
		
	@Override
	public Bus findByBusId(Long id) {
		// TODO Auto-generated method stub
		try {
			return entityManager.find(Bus.class, id);
		}catch(Exception e) {
			System.out.println("Error findByBusId = "+e.getMessage());
			return null;
		}
	}

	@Override
	public List<Bus> findAllBus() {
		// TODO Auto-generated method stub
		try {
			LocalDate localDate = LocalDate.now();
			String jpql="select b from Bus b where b.journeyDate>?1";
			return entityManager.createQuery(jpql, Bus.class).setParameter(1, localDate ).getResultList();
		}catch(Exception e) {
			System.out.println("Error findAllBus = "+e.getMessage());
			return null;
		}
	}

	
	@Override
	@Transactional
	public String deleteBusDtl(long busId) {
		String mesg="Bus deletion failed";
		try {
			Bus busDtl=entityManager.find(Bus.class, busId);
			if(busDtl != null)
			{
				entityManager.remove(busDtl);
				mesg="Bus deleted successfully";
			}
		}catch(Exception e) {
			System.out.println("Error deleteBusDtl = "+e.getMessage());
			return null;
		}
		return mesg;
	}

	@Override
	@Transactional
	public Bus addBusDtl(Bus bus) {
		
		try {
			entityManager.persist(bus);
			
	//		Session session=this.sessionFactory.getCurrentSession();
	//		session.save(bus);
		}catch(Exception e) {
			System.out.println("Error while Saving the Bus Detail = "+e.getMessage());
			return null;
		}
		return bus;
	}
	

	@Override
	@Transactional
	public Passenger addPassengerDtl(Passenger passenger) {
		
		try {
			entityManager.persist(passenger);
			
	//		Session session=this.sessionFactory.getCurrentSession();
	//		session.save(bus);
		}catch(Exception e) {
			System.out.println("Error while Saving the Passenger Detail = "+e.getMessage());
			return null;
		}
		return passenger;
	}
	

	@Override
	@Transactional
	public Payment addPaymentDtl(Payment payment) {
		// TODO Auto-generated method stub
		try {
			entityManager.persist(payment);
			
	//		Session session=this.sessionFactory.getCurrentSession();
	//		session.save(bus);
		}catch(Exception e) {
			System.out.println("Error while Saving the Payment Detail = "+e.getMessage());
			return null;
		}
		return payment;
	}
	
	@Override
	@Transactional
	public int updateAvailableSeats(Long busId, Integer availableSeats) {
		// TODO Auto-generated method stub
		int executeUpdateFlag=0;
		try {
		  String queryupdate = "UPDATE Bus SET availableSeats=?1 WHERE id=?2 "; 
		    executeUpdateFlag= entityManager.createQuery(queryupdate).setParameter(1, availableSeats).setParameter(2, busId ).executeUpdate();
		}catch(Exception e) {
			System.out.println("Error while Updating Bus ID = "+e.getMessage());
			return -1;
		}
		return executeUpdateFlag;
	}

	@Override
	@Transactional
	public Driver addDriverDetail(Driver driver) {
		// TODO Auto-generated method stub
		try {
			entityManager.persist(driver);
			
	//		Session session=this.sessionFactory.getCurrentSession();
	//		session.save(driver);
		}catch(Exception e) {
			System.out.println("Error while Saving the Driver Detail = "+e.getMessage());
			return null;
		}
		return driver;
	}

	
	@Override
	public List<Passenger> getTicketBookingDetails(Long userId) {
		// TODO Auto-generated method stub
		try {
			String jpql="";
			if(userId!=null) {//specific to customer
				jpql="select ps from Passenger ps INNER JOIN ps.payment py"
						+ "  INNER JOIN ps.bus bus  INNER JOIN ps.user user WHERE ps.user.userId="+userId;
			}else {//specific to admin
				jpql="select ps from Passenger ps INNER JOIN ps.payment py"
						+ "  INNER JOIN ps.bus bus ";
			}
			
			
			return entityManager.createQuery(jpql, Passenger.class).getResultList();
		}catch(Exception e) {
			System.out.println("Error getPassengerDetail = "+e.getMessage());
			return null;
		}
	}

	@Override
	public List<Driver> findDriverByBusId(Long busId) {
		// TODO Auto-generated method stub
		try {
			String jpql="select d from Driver d where d.bus.id='"+busId+"'";
			return entityManager.createQuery(jpql, Driver.class).getResultList();
		}catch(Exception e) {
			System.out.println("Error findDriverByBusId = "+e.getMessage());
			return null;
		}
	}

	@Override
	public List<Bus> getAvailableBusDetail() {
		// TODO Auto-generated method stub
		  LocalDate localDate = LocalDate.now();
		try {
			String jpql="select b from Bus b where b.availableSeats>?1 and b.journeyDate>?2";
			return entityManager.createQuery(jpql, Bus.class).setParameter(1, 0).setParameter(2, localDate ).getResultList();
		}catch(Exception e) {
			System.out.println("Error getAvailableBusDetail = "+e.getMessage());
			return null;
		}
	}

}
