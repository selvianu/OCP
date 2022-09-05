package com.chainsys.BookSalesMgmtSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.AdminMapper;
import com.chainsys.BookSalesMgmtSystem.model.Admin;

@Repository
public class AdminDoa {

	@Autowired
	JdbcTemplate temp;
	
	@Autowired
	Admin adm;
	
	public Admin adminLogin(String uname, String pwd) {
		System.out.println("Inside DOA");
		String q = "select * from admin";
		Admin info = null;
		try {
			info = temp.queryForObject(q, new AdminMapper());
			System.out.println(info.getAdminUserName() + " " + info.getAdminPassword());
			System.out.println("Bye DOA");
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return info;
	}
}
