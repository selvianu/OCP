package com.chainsys.BookSalesMgmtSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.BookSalesMgmtSystem.dao.BookDao;
import com.chainsys.BookSalesMgmtSystem.dao.OrderDao;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;

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
}
