package com.chainsys.BookSalesMgmtSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.model.Employees;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate temp;

	public int addEmp(Employees emp) {
		String q = "insert into empdetails(empid, empname, password, emailid, phoneno, dob, address, district, state, pincode, workloc)"
				+ "values(empid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = {emp.getEmpName(), emp.getPassword(), emp.getEmailId(), emp.getPhoneno(),
				emp.getDateOfBirth(), emp.getAddress(), emp.getDistrict(), emp.getState(), emp.getPincode(), emp.getWorkLoc() };
		int flag = temp.update(q, data);
		return flag;
	}
	
	public String getEmpId(String email) {
		String q = "select empid from empDetails where emailid = ?";
		String queryObject = null;
		try {
			queryObject = temp.queryForObject(q, String.class, email);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return queryObject;
	}
}
