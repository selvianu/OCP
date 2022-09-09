package com.chainsys.BookSalesMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.OrderDao;
import com.chainsys.BookSalesMgmtSystem.dao.UserDao;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;

@Service

public class UserService {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	public List<Books> getTopBooks(){
		List<Books> topBooks = bookDao.getTopSaledBooks();
		return topBooks;
	}
	
	public List<Books> getBooks(){
		List<Books> bkList = bookDao.getBookList();
		return bkList;
	}
	
	public List<Books> getNovelBooks(){
		List<Books> novels = bookDao.getNovelBooks();
		return novels;
	}
	
	public List<Books> getPoetryBooks(){
		List<Books> poetry = bookDao.getPoetryBooks();
		return poetry;
	}
	
	public List<Books> getHistoryBooks(){
		List<Books> history = bookDao.getHistoryBooks();
		return history;
	}
	
	public List<Books> getEducationBooks(){
		List<Books> educ = bookDao.getEducationBooks();
		return educ;
	}
	
	public List<Books> getBiographyBooks(){
		List<Books> biography = bookDao.getBiographyBooks();
		return biography;
	}

	public Books getBookById(String bookId) {
		Books books =  bookDao.getBookById(bookId);
		return books;
	}
	
	public List<Books> getBookBycategory(String category){
		List<Books> categoryBook = null;
		if(category.equals("Novel")) {
			categoryBook = getNovelBooks();
			return categoryBook;
		}
		else if(category.equals("Poetry")) {
			categoryBook = getPoetryBooks();
			return categoryBook;
		}
		else if(category.equals("History")) {
			categoryBook = getHistoryBooks();
			return categoryBook;
		}
		else if(category.equals("Education")){
			categoryBook = getEducationBooks();
			return categoryBook;
		}
		else if(category.equals("Biography")) {
			categoryBook = getBiographyBooks();
			return categoryBook;
		}
		return null;
	}

	public boolean addToCart(Cart cart) {
		int noOfRowsAffected = orderDao.addcart(cart);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<CartDetails> getCart(String username){
		List<CartDetails> cart = orderDao.getCart(username);
		return cart;
	}
	
	public boolean deleteCart(int cartId) {
		int noOfRowsAffected = orderDao.deleteCart(cartId);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean updatePassword(String username, String password) {
		if(!userDao.checkUserNameAvail(username)) {
			int noOfRowsAffected = userDao.updatePassword(username, password);
			if(noOfRowsAffected > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public List<Books> searchBooks(String keyword) {
		List<Books> searchBooks = bookDao.searchBooks(keyword);
		return searchBooks;
	}
	
	public List<Books> getBooksByLanguage(String language){
		List<Books> bookList = bookDao.getBookByLanguage(language);
		return bookList;
	}
	
	public List<Books> getBooksByPrice(int fromRate, int toRate){
		List<Books> bookList = bookDao.getBookByPrice(fromRate, toRate);
		return bookList;
	}
	
	public List<Books> getBooksByAuthor(String author){
		List<Books> bookList = bookDao.getBookByAuthor(author);
		return bookList;
	}
}
