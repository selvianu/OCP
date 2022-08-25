package com.chainsys.BookSalesMgmtSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.model.Users;

@Repository
public class UserDoa {

	@Autowired
	JdbcTemplate temp;

	public int signin(Users us) {
		String q = "insert into userDetails(username, password, emailid) values (?, ?, ?)";
		Object[] data = { us.getUserName(), us.getPassword(), us.getEmailId() };// create the object for execute the
																				// query
		int flag = temp.update(q, data);// execute the query
		return flag;
	}

	public boolean login(String userName, String password) {

		String q = "select password from userDetails where username = ?";
		String queryObject = null;
		try {
			queryObject = temp.queryForObject(q, String.class, userName);
			if (queryObject == null) {
				return false;
			} else {
				if (queryObject.equals(password)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkUserNameAvail(String userName) {

		String q = "select password from userDetails where username = ?";
		String queryObject = null;
		try {
			queryObject = temp.queryForObject(q, String.class, userName);
			System.out.println(queryObject);
			if (queryObject == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
	}

}
