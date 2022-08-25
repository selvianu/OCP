package com.chainsys.BookSalesMgmtSystem.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Employees;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Controller
public class BookCtrller {

	@Autowired
	BookDao bkdoa;

	@Autowired
	Books bk;

	@GetMapping("/addBooks")
	public String insertBooks(@RequestParam("bkid") String bookId, @RequestParam("bkname") String bookName,
			@RequestParam("authorname") String author, @RequestParam("publisher") String publisher,
			@RequestParam("category") String category, @RequestParam("language") String language,
			@RequestParam("edition") int edition, @RequestParam("quantity") int quantity,
			@RequestParam("price") int price, @RequestParam("mrpRate") int mrpRate, Model model) {
		try {
			int actPrice = mrpRate - 5;// calculate the actual rate of the book

			// set all data of the book model
			bk.setBookId(bookId);
			bk.setBookName(bookName);
			bk.setAuthor(author);
			bk.setPublisher(publisher);
			bk.setEdition(edition);
			bk.setCategory(category);
			bk.setLanguage(language);
			bk.setPrice(price);
			bk.setMrpRate(mrpRate);
			bk.setActPrice(actPrice);
			bk.setAvlQuantity(quantity);

			// check whether the data are inserted or not

			int f = bkdoa.addBooks(bk);
			if (f > 0) {
				model.addAttribute("msg", "Successfully Added!");
				return "addbooks.jsp";
			} else {
				model.addAttribute("msg", "Some Internel problem. Please try again later!");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "Some Unexpected Exception may occur");
		}
		return "addbooks.jsp";
	}
	
	
	
}
