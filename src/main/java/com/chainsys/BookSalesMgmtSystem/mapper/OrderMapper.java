package com.chainsys.BookSalesMgmtSystem.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.BookSalesMgmtSystem.model.Orders;

public class OrderMapper implements RowMapper<Orders>{

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int ordreId = rs.getInt("orderid");
		String bkId = rs.getString("booksId");
		String usname = rs.getString("username");
		Date orderDate = rs.getDate("orderDate");
		int qty = rs.getInt("Quantity");
		int price = rs.getInt("totalprice");
		int adAmt = rs.getInt("advanceamt");
		String status = rs.getString("status");
		String name = rs.getString("name");
		String email = rs.getString("emailid");
		String phoneno = rs.getString("phoneno");
		String address = rs.getString("address");
		String district = rs.getString("district");
		String state = rs.getString("state");
		int pincode = rs.getInt("pincode");
		
		Orders od = new Orders();
		od.setOrderId(ordreId);
		od.setBookId(bkId);
		od.setUserName(usname);
		od.setOrderDate(orderDate);
		od.setQuantity(qty);
		od.setTotalPrice(price);
		od.setAdvanceAmt(adAmt);
		od.setStatus(status);
		od.setName(name);
		od.setEmailId(email);
		od.setPhoneno(phoneno);
		od.setAddress(address);
		od.setDistrict(district);
		od.setState(state);
		od.setPincode(pincode);
		return od;
	}

	
}
