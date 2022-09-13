package com.chainsys.BookSalesMgmtSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.OrderDao;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;
import com.chainsys.BookSalesMgmtSystem.model.Rating;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	BookDao bookDao;
	
	public boolean addOrder(OrdersDetails orderDetails) {
		int noOfRowAffected = orderDao.addOrder(orderDetails);
		if(noOfRowAffected > 0) {
			int availableQuantity = bookDao.getQuantityById(orderDetails.getBookId());
			int remainingQuantity = availableQuantity - orderDetails.getQuantity();
			bookDao.updateQuantity(remainingQuantity, orderDetails.getBookId());
			return true;
		}
		else {
			return false;
		}
	}
	
//	public int checkAvailableQuantity(String bookId, int requiredQuantity) {
//		int availableQuantity = bookDao.getQuantityById(bookId);
//		if(requiredQuantity > availableQuantity) {
//			return requiredQuantity - availableQuantity;
//		}
//		else {
//			return 0;
//		}
//	}
	
	public boolean cancelOrder(int orderId, String Status) {
		int noOfRowsAffected = orderDao.updateOrder(orderId, Status);
		if(noOfRowsAffected > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean addRating(Rating rating) {
		int noOfRowsAffected1 = orderDao.addRating(rating);
		if(noOfRowsAffected1 > 0) {
			String bookId = rating.getBookId();
			int rate = orderDao.getSumOfRating(bookId) / orderDao.getNumberOfREviewers(bookId);
			int noOfRowsAffected2 = orderDao.updateBookRating(bookId, rate);
			if(noOfRowsAffected2 > 0) {
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
	
	public List<OrdersDetails> getOrderById(String userName){
		List<OrdersDetails> orderList = orderDao.getOrdersById(userName);
		return orderList;
	}
	
}
