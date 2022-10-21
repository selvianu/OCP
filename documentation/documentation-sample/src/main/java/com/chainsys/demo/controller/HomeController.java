package com.chainsys.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/welcome")
	public String userList() {
		return "welcomePage";
	}

	@GetMapping("/admin")
	public String listOfUsers() {
		return "admin";
	}
}
