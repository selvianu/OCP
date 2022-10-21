package com.chainsys.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.demo.user.model.User;

@RestController
public class UserController {
	private static List<User> users = new ArrayList<User>();

	@GetMapping("/updateuser")
	public String userList() {
		return "userList";
	}

	@GetMapping("/deleteuser")
	public String deleteUser() {
		return "to delete user";
	}

	@GetMapping("/listusers")
	public List<User> listOfUsers() {
		System.out.println("listing users" + users);
		return users;

	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		users.add(user);
		System.out.println("User added");
		return user;
	}
}
