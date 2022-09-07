package com.chainsys.BookSalesMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.OrderDao;
import com.chainsys.BookSalesMgmtSystem.dao.UserDoa;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;

@Service

public class UserService {

	@Autowired
	BookDao bkdao;
	
	@Autowired
	OrderDao orderDao;
	
	public List<Books> getTopBooks(){
		List<Books> topBooks = bkdao.getTopSaledBooks();
		return topBooks;
	}
	
	public List<Books> getBooks(){
		List<Books> bkList = bkdao.getBookList();
		return bkList;
	}
	
	public List<Books> getNovels(){
		List<Books> novels = bkdao.getNovels();
		return novels;
	}
	
	public List<Books> getPoetry(){
		List<Books> poetry = bkdao.getPoetry();
		return poetry;
	}
	
	public List<Books> getHistory(){
		List<Books> history = bkdao.getHistory();
		return history;
	}
	
	public List<Books> getEducation(){
		List<Books> educ = bkdao.getEducation();
		return educ;
	}
	
	public List<Books> getBiography(){
		List<Books> biography = bkdao.getBiography();
		return biography;
	}

	public Books getBookById(String id) {
		Books bk =  bkdao.getBookById(id);
		return bk;
	}
	
	public List<Books> getBookBycategory(String category){
		List<Books> categoryBook = null;
		if(category.equals("Novel")) {
			categoryBook = getNovels();
			return categoryBook;
		}
		else if(category.equals("Poetry")) {
			categoryBook = getPoetry();
			return categoryBook;
		}
		else if(category.equals("History")) {
			categoryBook = getHistory();
			return categoryBook;
		}
		else if(category.equals("Education")){
			categoryBook = getEducation();
			return categoryBook;
		}
		else if(category.equals("Biography")) {
			categoryBook = getBiography();
			return categoryBook;
		}
		return null;
	}

	public boolean addToCart(Cart cart) {
		int flag = orderDao.addcart(cart);
		if(flag > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public List<CartDetails> getCart(String username){
		List<CartDetails> carts = orderDao.getCart(username);
		System.out.println(carts);
		return carts;
	}
}
