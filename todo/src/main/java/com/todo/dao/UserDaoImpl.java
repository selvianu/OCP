package com.todo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.todo.model.User;
import com.todo.validator.Validation;

public class UserDaoImpl implements UserDao {

	public void save(User user) {
		if (Validation.isValidUser(user.getName(), user.getPassword()) == true) {
			if (user.getName().equals(user.getPassword())) {
				System.out.println("Valid user");

				List<User> userList = new ArrayList<User>();
				userList.add(user);
				for (User user2 : userList) {
					System.out.println(user2);
				}
			} else {
				System.out.println("Invalid credentials");
			}
		}
	}
}
