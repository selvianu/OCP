package com.chainsys.BookSalesMgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.AdminDoa;
import com.chainsys.BookSalesMgmtSystem.model.Admin;

@Controller
public class AdminCtrller {

	@Autowired
	Admin adm;
	
	@Autowired
	AdminDoa admdoa;
	
	@GetMapping("/stafflogin")
	public String staffLogin(@RequestParam("username") String uname, @RequestParam("pwd") String pwd, Model model) {
		
		try {
			if(admdoa.adminLogin(uname, pwd)) {
				return "admin_landing.jsp";
			}
			else {
				model.addAttribute("msg", "Invalid password or username");
				return "login.jsp";
			}
		}catch (Exception e) {
			model.addAttribute("msg", "Some Internal problem! Please try again later!");
			return "login.jsp";
		}
	}
}
