package com.chainsys.BookSalesMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.AdminDao;
import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.UserDao;
import com.chainsys.BookSalesMgmtSystem.model.Admin;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Service
public class AdminService {

	@Autowired 
	AdminDao adminDoa;
	
	@Autowired
	UserDao userDoa;
	
	@Autowired
	BookDao bookDoa;
	
	public boolean checkIdentity(String uname, String pwd) {
		Admin admin = adminDoa.adminLogin(uname, pwd);
		if(uname.equals(admin.getAdminUserName()) && pwd.equals(admin.getAdminPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<Users> getUser() {
		List<Users> userData = userDoa.getUserList(); 
		return userData;
	}
	
	public boolean addBooks(Books bk) {
		int noOfRowsAffected = bookDoa.addBooks(bk);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<Books> getBooks(){
		List<Books> bookData = bookDoa.getBookList();
		return bookData;
	}
	
	public List<Books> getNovelBooks(){
		List<Books> novels = bookDoa.getNovelBooks();
		return novels;
	}
	
	public List<Books> getPoetryBooks(){
		List<Books> poetry = bookDoa.getPoetryBooks();
		return poetry;
	}
	
	public List<Books> getHistoryBooks(){
		List<Books> history = bookDoa.getHistoryBooks();
		return history;
	}
	
	public List<Books> getEducationBooks(){
		List<Books> educ = bookDoa.getEducationBooks();
		return educ;
	}
	
	public List<Books> getBiographyBooks(){
		List<Books> biography = bookDoa.getBiographyBooks();
		return biography;
	}

	public boolean updateBook(Books bk) {
		int noOfRowsAffected = bookDoa.updateBookDetails(bk);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean deleteBooks(String bookId) {
		int noOfRowsAffected = bookDoa.deleteBook(bookId);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<OrdersDetails> getOrders() {
		List<OrdersDetails> orderList = adminDoa.getOrderList();
		return orderList;
	}
	
	public List<Books> getTopSearchedBooks(){
		List<Books> topBooks = bookDoa.getTopSaledBooks();
		return topBooks;
	}
	
	public List<Books> getLowQuantityBooks(){
		List<Books> bookList = bookDoa.getLowQuantityBooks();
		return bookList;
	}
	
	public List<Users> getTopBuyers(){
		List<Users> userList = userDoa.getTopBuyers();
		return userList;
	}
}
