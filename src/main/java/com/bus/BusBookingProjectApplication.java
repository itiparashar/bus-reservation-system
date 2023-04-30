package com.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@ComponentScan("com.bus")
@SpringBootApplication
public class BusBookingProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(BusBookingProjectApplication.class, args);
	}

}
