package com.chainsys.BookSalesMgmtSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.service.UserService;

@Controller
public class filterCtrller {

	@Autowired
	UserService userService;
	
	@GetMapping("/under200")
	public String getBooksUnder200(Model model) {
		int from = 0;
		int to = 200;
		List<Books> booksList = userService.getBooksByPrice(from, to);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No books");
			return "allbooks.jsp";
		}
	}
	
	@GetMapping("/over500")
	public String getBooksOver500(Model model) {
		int from = 201;
		int to = 500;
		List<Books> booksList = userService.getBooksByPrice(from, to);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No books");
			return "allbooks.jsp";
		}
	}
	
	@GetMapping("/over800")
	public String getBooksOver800(Model model) {
		int from = 501;
		int to = 800;
		List<Books> booksList = userService.getBooksByPrice(from, to);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No books");
			return "allbooks.jsp";
		}
	}
	
	@GetMapping("/under1000")
	public String getBooksUnder1000(Model model) {
		int from = 801;
		int to = 1000;
		List<Books> booksList = userService.getBooksByPrice(from, to);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No books");
			return "allbooks.jsp";
		}
	}
	
	@GetMapping("/over1000")
	public String getBooksOver1000(Model model) {
		int from = 1000;
		int to = 10000;
		List<Books> booksList = userService.getBooksByPrice(from, to);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No books");
			return "allbooks.jsp";
		}
	}
	
	@GetMapping("/language")
	public String getBooksByLanguage(@RequestParam("lang") String language, Model model) {
		List<Books> booksList = userService.getBooksByLanguage(language);
		if(booksList != null) {
			model.addAttribute("books", booksList);
			return "allbooks.jsp";
		}
		else {
			model.addAttribute("msg", "No Books");
			return "allbooks.jsp";
		}
	}
}
