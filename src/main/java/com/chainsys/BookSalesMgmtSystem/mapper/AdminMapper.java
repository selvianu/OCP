package com.chainsys.BookSalesMgmtSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.chainsys.BookSalesMgmtSystem.model.Admin;

public class AdminMapper implements RowMapper<Admin> {
	
	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Inside mapper");
		String uname = rs.getString("user_name");
		System.out.println(uname);
		String pwd = rs.getString("password");
		System.out.println(uname + "  " + pwd);
		Admin admin = new Admin();
		admin.setAdminUserName(uname);
		admin.setAdminPassword(pwd);
		System.out.println(admin.getAdminUserName()  + "  "+ admin.getAdminPassword());
		System.out.println("Bye mapper");
		return admin;
	}

	
}
