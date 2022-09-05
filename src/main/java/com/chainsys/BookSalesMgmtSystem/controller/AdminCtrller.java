package com.chainsys.BookSalesMgmtSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.model.Admin;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Orders;
import com.chainsys.BookSalesMgmtSystem.model.Users;
import com.chainsys.BookSalesMgmtSystem.service.AdminService;

@Controller
public class AdminCtrller {

	@Autowired
	Admin adm;
	
	@Autowired
	AdminService adservice;
	
	@GetMapping("/adminlogin")
	public String staffLogin(@RequestParam("username") String uname, @RequestParam("pwd") String pwd, Model model) {
		try {
			if(adservice.checkIdentity(uname, pwd)) {
				return "admin_landing.jsp";
			}
			else {
				model.addAttribute("msg", "Invalid password or username");
				return "login.jsp";
			}
		}catch (Exception e) {
			model.addAttribute("msg", "Some Internal problem! Please try again later!");
			return "login.jsp";
		}
	}
	
	@GetMapping("/Users")
	public String getUserList(Model model) {
		List<Users> data = adservice.getUser();
		model.addAttribute("users", data);
		return "users.jsp";
	}
	
	@GetMapping("/Books")
	public String getBookList(Model model) {
		List<Books> data = adservice.getBooks();
		if(data != null) {
			model.addAttribute("books", data);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/Novels")
	public String getNovels(Model model) {
		List<Books> novels = adservice.getNovels();
		if(novels != null) {
			model.addAttribute("books", novels);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/Poetry")
	public String getPoetry(Model model) {
		List<Books> poetry = adservice.getPoetry();
		if(poetry != null) {
			model.addAttribute("books", poetry);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/History")
	public String getHistory(Model model) {
		List<Books> history = adservice.getHistory();
		if(history != null) {
			model.addAttribute("books", history);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/Education")
	public String getEducation(Model model) {
		List<Books> education = adservice.getEducation();
		if(education != null) {
			model.addAttribute("books",education);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/Biography")
	public String getBiography(Model model) {
		List<Books> biography = adservice.getBiography();
		if(biography != null) {
			model.addAttribute("books", biography);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/delete")
	public String editBook(@RequestParam("id") String bookId, Model model) {
		if(adservice.deleteBooks(bookId)) {
			model.addAttribute("msg", "The book is deleted successfully!");
			return "/Books";
		}
		else {
			model.addAttribute("msg", "Some Unexpected error is occur. Please try again later!");
			return "/Books";
		}
	}
	
	@GetMapping("/update")
	public String updateBook(@RequestParam("bkid") String id, @RequestParam("bkname") String name, @RequestParam("authorname") String author,
			@RequestParam("publisher") String pub, @RequestParam("edition") int edition,
			@RequestParam("quantity") int qty, @RequestParam("price") int price, @RequestParam("mrpRate") int mrp, Model model) {
		Books bk = new Books();
		bk.setBookId(id);
		bk.setBookName(name);
		bk.setAuthor(author);
		bk.setPublisher(pub);
		bk.setEdition(edition);
		bk.setAvlQuantity(qty);
		bk.setPrice(price);
		bk.setMrpRate(mrp);
		if(adservice.updateBook(bk)) {
			model.addAttribute("msg", "The book Details are Successfully Updated!");
			return "/Books";
		}
		else {
			model.addAttribute("msg", "Some Unexpected Problem may occured. Please try again later!");
			return "editbook.jsp";
		}
	}
	
	@GetMapping("/Orders")
	public String getOrders(Model model) {
		List<Orders> odList = adservice.getOrders();
		if(odList != null) {
			model.addAttribute("orderList", odList);
			return "orders.jsp";
		}
		else {
			model.addAttribute("msg", "No Orders available");
			return "orders.jsp";
		}
	}
}
