package com.chainsys.BookSalesMgmtSystem.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
			List<Books> lowQtyBooks = adminService.getLowQuantityBooks();
			List<Users> topUsers = adminService.getTopBuyers();
			model.addAttribute("topBooks", topBooks);
			model.addAttribute("lowQtyBooks", lowQtyBooks);
			model.addAttribute("topUsers", topUsers);
			return "admin_landing.jsp";
		}
	
	@PostMapping("/addBooks")
	public String insertBooks(@RequestParam("bkid") String bookId, @RequestParam("bkname") String bookName,
			@RequestParam("authorname") String author, @RequestParam("publisher") String publisher,
			@RequestParam("category") String category, @RequestParam("lang") String language,
			@RequestParam("edition") int edition, @RequestParam("quantity") int quantity,@RequestParam("price") int price, 
			@RequestParam("mrpRate") int mrpRate, @RequestParam("file") MultipartFile img, Model model) throws IOException {
		
			int actPrice = mrpRate - 5;// calculate the actual rate of the book
			String path = "C:\\eclipse\\BookSalesMgmtSystem\\src\\main\\webapp\\images\\";
			String filename = img.getOriginalFilename();
			FileInputStream fin = new FileInputStream(path+filename);
			byte[] images = fin.readAllBytes();
//			set all data of the book model
			Books books = new Books();
			books.setBookId(bookId);
			books.setBookName(bookName);
			books.setAuthor(author);
			books.setPublisher(publisher);
			books.setEdition(edition);
			books.setCategory(category);
			books.setLanguage(language);
			books.setPrice(price);
			books.setMrpRate(mrpRate);
			books.setActualPrice(actPrice);
			books.setAvailableQuantity(quantity);
			books.setBookImage(images);
			// check whether the data are inserted or not
			if(adminService.addBooks(books)) {
				model.addAttribute("msg", "Successfully Added!");
				return "addbooks.jsp";
			}
			else {
				model.addAttribute("msg", "Some Internel problem. Please try again later!");
				return "addbooks.jsp";
			}
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
