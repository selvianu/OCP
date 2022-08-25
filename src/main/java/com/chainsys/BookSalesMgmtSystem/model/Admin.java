package com.chainsys.BookSalesMgmtSystem.model;

import org.springframework.stereotype.Repository;

@Repository
public class Admin {

	private String adminUserName = "MarsAdmin";
	private String adminPassword = "Mars@6253Admin";

	public String getAdminUserName() {
		return adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

}
