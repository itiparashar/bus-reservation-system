/**
 * 
 */
package com.bus.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bus.model.Bus;
import com.bus.model.Driver;
import com.bus.model.Passenger;
import com.bus.model.User;
import com.bus.pojo.TicketBookingDTO;
import com.bus.service.BusService;
import com.bus.service.UserService;

@Controller
public class BusBookingController {

	@Autowired
	BusService busService;

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String indexPage() {
		return "index";// actual view name : /WEB-INF/views/index.jsp
	}

	@RequestMapping(value = "/addBus", method = RequestMethod.GET)
	public String addBusPage(ModelMap model) {
		try {
			model.addAttribute("bus", new Bus());
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
		}
		return "addBus";
	}

	@RequestMapping(value = "/addBusDetail", method = RequestMethod.POST)
	public String addBusDetailPage(Bus bus, ModelMap model, HttpSession session) {
		try {
			User user = (User) session.getAttribute("userDtl");
			bus.setUser(user);
			Bus busDtl = busService.addBusDetail(bus);
			if (busDtl == null) {
				model.put("errorMessage", " Error While Inserting Bus Record. ");
				return "redirect:/addBus";
			} else {
				return "redirect:/busReport";
			}
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "redirect:/addBus";
		}
	}

	@RequestMapping(value = "/addDriver", method = RequestMethod.GET)
	public String addDriverPage(ModelMap model) {
		try {
			model.addAttribute("driver", new Driver());
			model.addAttribute("busList", busService.busDetail());
			return "addDriver";

		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "addDriver";
		}
	}

	@RequestMapping(value = "/addDriverDetail", method = RequestMethod.POST)
	public String addDriverDetailPage(Driver driver, ModelMap model, HttpSession session) {
		try {
			User user = (User) session.getAttribute("userDtl");
			driver.setUser(user);
			Driver driverDtl = busService.addDriverDetail(driver);

			if (driverDtl == null) {
				model.put("errorMessage", " Error While Inserting Driver Record. ");
				return "redirect:/addDriver";
			} else {
				return "redirect:/busReport";
			}
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "redirect:/addDriver";
		}
	}

	@RequestMapping(value = "/busReport", method = RequestMethod.GET)
	public String busReportPage(ModelMap model) {
		try {
			List<Bus> busList = busService.busDetail();

			model.addAttribute("busList", busList);
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "busReport";
		}
		return "busReport";
	}

	@RequestMapping(value = "/driverDetail", method = RequestMethod.GET)
	public String driverDetailPage(ModelMap model, @RequestParam Long busId) {
		try {
			List<Driver> driverList = busService.driverDetail(busId);

			model.addAttribute("driverList", driverList);
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "driverDetail";
		}
		return "driverDetail";
	}

	@RequestMapping(value = "/deleteBus", method = RequestMethod.GET)
	public String deleteBus(@RequestParam long busId, HttpSession session, ModelMap model) {
		try {
			System.out.println("in delete bus");
			String message = busService.deleteBus(busId);
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "redirect:/busReport";
		}
		return "redirect:/busReport";
	}

	@RequestMapping(value = "/bookTicket", method = RequestMethod.GET)
	public String bookTicket(Model model, @RequestParam(required = false) Long busId) {
		try {
			// List<Bus> busList = busService.busDetail();
			if(busId!=null)
				model.addAttribute("selectedBusId", busId);
			else {
				List<Bus> busList = busService.getAvailableBusDetail();
				model.addAttribute("busList", busList);
			}
			model.addAttribute("ticketBookingDTO", new TicketBookingDTO());
		} catch (Exception e) {
			model.addAttribute("errorMessage", " Error while showing page ");
			return "bookTicket";
		}
		return "bookTicket";
	}

	@RequestMapping(value = "/bookTicketDtl", method = RequestMethod.POST)
	public String bookTicketDtl(ModelMap model, TicketBookingDTO ticketBookingDTO, HttpSession session) {
		try {
			if (ticketBookingDTO != null) {
				Long successFlag = busService.payBookTicket(ticketBookingDTO, session);
				if (successFlag != null) {
					Long passengerId = successFlag;
					// show

					model.put("successMessgae", "Thank You..! booking details Added successfully. Check below details. " );
					model.put("ticketBookingDTO", ticketBookingDTO);

					return "ticketBookingPaymentDetail";
				} else {
					model.put("errorMessage", " Error While Booking Ticket. ");
					model.addAttribute("selectedBusId", ticketBookingDTO.getSelectedBusId());
					return "redirect:/bookTicket";
				}
			} else {
				model.put("errorMessage", " Error While Booking Ticket. ");
				model.addAttribute("selectedBusId", ticketBookingDTO.getSelectedBusId());
				return "redirect:/bookTicket";
			}
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "redirect:/bookTicket";
		}
		// model.addAttribute("busList", busList);

	}

	@RequestMapping(value = "/ticketHistory", method = RequestMethod.GET)
	public String ticketHistoryPage(ModelMap model, @RequestParam(required = false) Long userId) {

		try {
			List<Passenger> ticketBookingDTOList = busService.getTicketBookingDetailList(userId);

			model.addAttribute("ticketBookingDTOList", ticketBookingDTOList);
			return "ticketHistory";
		} catch (Exception e) {
			model.put("errorMessage", " Error while showing page ");
			return "ticketHistory";
		}
	}

}
