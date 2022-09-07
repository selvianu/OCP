package com.chainsys.BookSalesMgmtSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.AdminMapper;
import com.chainsys.BookSalesMgmtSystem.mapper.BookMapper;
import com.chainsys.BookSalesMgmtSystem.mapper.OrderMapper;
import com.chainsys.BookSalesMgmtSystem.model.Admin;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Orders;

@Repository
public class AdminDoa {

	@Autowired
	JdbcTemplate temp;
	
	@Autowired
	Admin adm;
	
	public Admin adminLogin(String uname, String pwd) {
		String q = "select * from admin";
		Admin info = null;
		try {
			info = temp.queryForObject(q, new AdminMapper());
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return info;
	}
	
	public List<Orders> getOrderList(){
		String q = "select * from orderhistory inner join userdetails on orderhistory.username = userdetails.username";
		List<Orders> orderList = null;
		try {
			orderList = temp.query(q, new OrderMapper());
			return orderList;
		}catch (Exception e) {
			return null;
		}
		
	}
}
