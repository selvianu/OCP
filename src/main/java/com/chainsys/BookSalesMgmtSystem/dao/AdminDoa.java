package com.chainsys.BookSalesMgmtSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.model.Admin;

@Repository
public class AdminDoa {

	@Autowired
	JdbcTemplate temp;
	
	@Autowired
	Admin adm;
	
	public boolean adminLogin(String uname, String pwd) {
		if((uname.equals(adm.getAdminUserName())) && (pwd.equals(adm.getAdminPassword()))) {
			return true;
		}
		else {
			return false;
		}
	}
}
