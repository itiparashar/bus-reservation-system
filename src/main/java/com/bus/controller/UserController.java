package com.bus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bus.model.Bus;
import com.bus.model.User;
import com.bus.pojo.ChangePasswordDTO;
import com.bus.service.UserService;

@Controller
public class UserController {

	

	@Autowired
	UserService userService;	
	

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String addBusPage(ModelMap model) {
	
		//model.addAttribute("bus", new Bus());
       
        return "login";
	}

	@RequestMapping(value="/checkLogIn", method = RequestMethod.POST)
	public String checklogInPage(ModelMap model, @RequestParam String userid, @RequestParam String pass, HttpSession session) {
		try {
	        User user = userService.validateUser(userid, pass);
	
	        if (user == null) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }else {
	        	session.setAttribute("userDtl", user);
	        	session.setAttribute("userName", user.getFirstName()+" "+user.getLastName());
	        }
		} catch (Exception e) {
			model.put("errorMessage", " Error while Log in page ");
			return "redirect:/login";
		}
        return "welcome";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage(ModelMap model,User user) {
		try {
			model.addAttribute("user", new User());
		} catch (Exception e) {
			model.put("errorMessage", " Error while Showing register page ");
			return "redirect:/login";
		}
        return "register";
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String saveUser(ModelMap model,User user) {
		try {
	        User userDtl = userService.addUser(user);
	
	        if (user == null) {
	            model.put("errorMessage", "Error while saving User Data.");
	            return "redirect:/register";
	        }else {
	        	 model.put("successMessgae", userDtl.getFirstName()+" "+userDtl.getLastName()+"User Added Successfully");
	        }
		} catch (Exception e) {
			model.put("errorMessage", " Error during register ");
			return "redirect:/register";
		}
        return "redirect:/login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logOutPage(ModelMap model, HttpSession session) {
		try {
			if(session!=null) {
				session.removeAttribute("userDtl");
				session.removeAttribute("userName");
				session.invalidate();
			}
			model.put("successMessgae", "User Log Out Successfully");
		} catch (Exception e) {
			model.put("errorMessage", " Error during Log Out ");
			return "redirect:/register";
		}
        return "index";
	}


	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
	public String changePasswordPage(Model model,  HttpSession session) {
		User userDtl = (User) session.getAttribute("userDtl");
		ChangePasswordDTO changePasswordDTO=new ChangePasswordDTO();
		changePasswordDTO.setChangePasswordUserId(userDtl.getUserId());
		model.addAttribute("changePasswordUserId", ""+userDtl.getUserId());
		model.addAttribute("changePasswordDTO",changePasswordDTO);
        return "changePassword";
	}
	
	@RequestMapping(value="/changePasswordDtl", method = RequestMethod.POST)
	public String changePasswordDtl(ModelMap model,ChangePasswordDTO changePasswordDTO, HttpSession session) {

		User userDtl = userService.findById(changePasswordDTO.getChangePasswordUserId());
		String userPass=userDtl.getPassword();
		if(!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword())) {
		
			model.put("errorMessage", "New Password & confirm Password is not matching");
			model.put("changePasswordUserId",changePasswordDTO.getChangePasswordUserId());
	        return "changePassword";
	        
		}else if(!userPass.equals(changePasswordDTO.getOldPassword())) {
			
			model.put("errorMessage", "Old Password is incorrect");
			model.put("changePasswordUserId",changePasswordDTO.getChangePasswordUserId());
	        return "changePassword";
		}else if(changePasswordDTO.getNewPassword().equals(changePasswordDTO.getOldPassword())) {
			
			model.put("errorMessage", "Please Check Old Password & New Password Both Are Same. ");
			model.put("changePasswordUserId",changePasswordDTO.getChangePasswordUserId());
	        return "changePassword";
		}else {
			int successFlag=userService.changePasswordDtl(changePasswordDTO.getChangePasswordUserId(), changePasswordDTO.getNewPassword());
			
			if(successFlag == 1 ) {
				model.put("successMessgae", "Password Changed Successfully");
				return "index";
			}else {
				model.put("errorMessage", "Error While Changing The Password ");
				return "changePassword";
			}
		}
	}
}
