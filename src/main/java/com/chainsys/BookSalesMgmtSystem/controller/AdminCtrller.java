package com.chainsys.BookSalesMgmtSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;
import com.chainsys.BookSalesMgmtSystem.model.Users;
import com.chainsys.BookSalesMgmtSystem.service.AdminService;

@Controller
public class AdminCtrller {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/adminlogin")
	public String adminLogin(@RequestParam("username") String userName, @RequestParam("pwd") String password, Model model) {
		try {
			if(adminService.checkIdentity(userName, password)) {
				
				return "adminHome";
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
	
	@GetMapping("/adminHome")
		public String adminHome(Model model) {
			List<Books> topBooks = adminService.getTopSearchedBooks();
			model.addAttribute("topBooks", topBooks);
			return "admin_landing.jsp";
		}
	
	@GetMapping("/Users")
	public String getUserList(Model model) {
		List<Users> userList = adminService.getUser();
		model.addAttribute("users", userList);
		return "users.jsp";
	}
	
	@GetMapping("/Books")
	public String getBookList(Model model) {
		List<Books> bookList = adminService.getBooks();
		if(bookList != null) {
			model.addAttribute("books", bookList);
			return "books.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "books.jsp";
		}
	}
	
	@GetMapping("/Novels")
	public String getNovels(Model model) {
		List<Books> novels = adminService.getNovelBooks();
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
		List<Books> poetry = adminService.getPoetryBooks();
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
		List<Books> history = adminService.getHistoryBooks();
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
		List<Books> education = adminService.getEducationBooks();
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
		List<Books> biography = adminService.getBiographyBooks();
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
	public String deleteBook(@RequestParam("id") String bookId, Model model) {
		if(adminService.deleteBooks(bookId)) {
			model.addAttribute("msg", "The book is deleted successfully!");
			return "/Books";
		}
		else {
			model.addAttribute("msg", "Some Unexpected error is occur. Please try again later!");
			return "/Books";
		}
	}
	
	@GetMapping("/update")
	public String updateBook(@RequestParam("bookid") String id, @RequestParam("bookname") String name, @RequestParam("author") String author,
			@RequestParam("publisher") String publisher, @RequestParam("edition") int edition,
			@RequestParam("quantity") int quantity, @RequestParam("price") int price, @RequestParam("actualPrice") int actualPrice, @RequestParam("mrpRate") int mrp, Model model) {
		Books books = new Books();
		books.setBookId(id);
		books.setBookName(name);
		books.setAuthor(author);
		books.setPublisher(publisher);
		books.setEdition(edition);
		books.setAvailableQuantity(quantity);
		books.setPrice(price);
		books.setActualPrice(actualPrice);
		books.setMrpRate(mrp);
		if(adminService.updateBook(books)) {
			model.addAttribute("msg", "The book Details are Successfully Updated!");
			return "/Books";
		}
		else {
			model.addAttribute("msg", "Some Unexpected Problem may occured. Please try again later!");
			return "editbook.jsp";
		}
	}
	
	@GetMapping("/Orders")
	public String getOrdersList(Model model) {
		List<OrdersDetails> orderList = adminService.getOrders();
		if(orderList != null) {
			model.addAttribute("orderList", orderList);
			return "orders.jsp";
		}
		else {
			model.addAttribute("msg", "No Orders available");
			return "orders.jsp";
		}
	}
}
