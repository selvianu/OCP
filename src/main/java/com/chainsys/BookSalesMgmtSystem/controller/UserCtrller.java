package com.chainsys.BookSalesMgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.UserDoa;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Controller
public class UserCtrller {

	@Autowired
	Users us;
	
	@Autowired
	UserDoa usdoa;
	
	@GetMapping("/signin")
	public String signup(@RequestParam("username") String uname, @RequestParam("email") String email, @RequestParam("pwd") String pwd, Model model) {
		
		try {
			
			if(usdoa.checkUserNameAvail(uname)) {
				us.setUserName(uname);
				us.setPassword(pwd);
				us.setEmailId(email);
				int f = usdoa.signin(us);
				if(f > 0) {
					return "user_landing.jsp";
				}
				else {
					model.addAttribute("msg", "Some internal problem Please try again later");
					return "signin.jsp";
				}
			}
			else {
				model.addAttribute("msg", "Username is already exists!. Please click login! or Try with another Username");
				return "signin.jsp";
			}
			
			
		}catch (Exception e) {
			model.addAttribute("msg", "Some internal problem Please try again later");
			return "signin.jsp";
		}
	}
	
	@GetMapping("/userlogin")
	public String login(@RequestParam("username") String uname, @RequestParam("pwd") String pwd, Model model) {
		
		try {
			if(usdoa.login(uname, pwd)) {
				return "user_landing.jsp";
			}
			else {
				model.addAttribute("msg", "Invalid username or password. Please check your username and password");
				return "login.jsp";
			}
		}catch (Exception e) {
			model.addAttribute("msg", "Some internal problem! Please try again later!");
		}
		return "success";
	}
}
