package com.chainsys.BookSalesMgmtSystem.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.model.Books;

@Controller
public class BookCtrller {

	@Autowired
	BookDao bookDoa;

	@PostMapping("/addBooks")
	public String insertBooks(@RequestParam("bkid") String bookId, @RequestParam("bkname") String bookName,
			@RequestParam("authorname") String author, @RequestParam("publisher") String publisher,
			@RequestParam("category") String category, @RequestParam("lang") String language,
			@RequestParam("edition") int edition, @RequestParam("quantity") int quantity,@RequestParam("price") int price, 
			@RequestParam("mrpRate") int mrpRate, @RequestParam("file") MultipartFile img, Model model) throws IOException {
		try {
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

			int noOfRowsAffected = bookDoa.addBooks(books);
			if (noOfRowsAffected > 0) {
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
