package com.chainsys.BookSalesMgmtSystem.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.AdminDoa;
import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.UserDoa;
import com.chainsys.BookSalesMgmtSystem.model.Admin;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Orders;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Service
public class AdminService {

	@Autowired 
	AdminDoa adoa;
	
	@Autowired
	Admin ad;
	
	@Autowired
	UserDoa usdoa;
	
	@Autowired
	BookDao bkdoa;
	
	public boolean checkIdentity(String uname, String pwd) {
		Admin admin = adoa.adminLogin(uname, pwd);
		if(uname.equals(admin.getAdminUserName()) && pwd.equals(admin.getAdminPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<Users> getUser() {
		List<Users> userData = usdoa.getUserList(); 
		return userData;
	}
	
	public boolean addBooks(Books bk) {
		int f = bkdoa.addBooks(bk);
		if(f > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Books> getBooks(){
		List<Books> bkData = bkdoa.getBookList();
		return bkData;
	}
	
	public List<Books> getNovels(){
		List<Books> novels = bkdoa.getNovels();
		return novels;
	}
	
	public List<Books> getPoetry(){
		List<Books> poetry = bkdoa.getPoetry();
		return poetry;
	}
	
	public List<Books> getHistory(){
		List<Books> history = bkdoa.getHistory();
		return history;
	}
	
	public List<Books> getEducation(){
		List<Books> educ = bkdoa.getEducation();
		return educ;
	}
	
	public List<Books> getBiography(){
		List<Books> biography = bkdoa.getBiography();
		return biography;
	}
	
	public Books getBk(String id) {
		Books bk = bkdoa.editBookDetails(id);
		return bk;
	}
	
	public boolean updateBook(Books bk) {
		int flag = bkdoa.updateBookDetails(bk);
		if(flag > 0) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean deleteBooks(String bookId) {
		int f = bkdoa.deleteBook(bookId);
		if(f > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Orders> getOrders() {
		List<Orders> odList = adoa.getOrderList();
		return odList;
	}
}
