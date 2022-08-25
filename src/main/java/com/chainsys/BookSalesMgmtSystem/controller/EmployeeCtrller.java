package com.chainsys.BookSalesMgmtSystem.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.EmployeeDao;
import com.chainsys.BookSalesMgmtSystem.model.Employees;

@Controller
public class EmployeeCtrller {

	@Autowired
	Employees emp;

	@Autowired 
	EmployeeDao empdao;

	@GetMapping("/addEmp")
	public String addEmployee(@RequestParam("empname") String empname, @RequestParam("pwd") String pwd, @RequestParam("phno") String phno, @RequestParam("email") String email,
			@RequestParam("dob") String dob, @RequestParam("addr") String addr, @RequestParam("dist") String dist, @RequestParam("state") String state, @RequestParam("pincode") int pincode,
			@RequestParam("workLoc") String workloc, Model model) {
		
		try {
			
			LocalDate date = LocalDate.parse(dob);
			Date dob1 = Date.valueOf(date);
			emp.setEmpName(empname);
			emp.setPassword(pwd);
			emp.setEmailId(email);
			emp.setDateOfBirth(dob1);
			emp.setPhoneno(phno);
			emp.setAddress(addr);
			emp.setDistrict(dist);
			emp.setState(state);
			emp.setPincode(pincode);
			emp.setWorkLoc(workloc);
			
			int f = empdao.addEmp(emp);
			if(f > 0) {
				String id = empdao.getEmpId(email);
				model.addAttribute("id", id);
				return "addemp.jsp";
			}
			else {
				return "error";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
