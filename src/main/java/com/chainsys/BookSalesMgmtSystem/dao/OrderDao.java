package com.chainsys.BookSalesMgmtSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.CartMapper;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;

@Repository
public class OrderDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addcart(Cart cart) {
		String insertCart = "INSERT INTO cartdetails(cart_id, username, booksid)values(cardId.nextval, ?, ?)";
		// create the object for execute the query
		Object[] cartData = {cart.getUserName(), cart.getBookId()};
		int noOfRowsAffected = jdbcTemplate.update(insertCart, cartData);// execute the query
		return noOfRowsAffected;
	}
	
	public List<CartDetails> getCart(String userName){
		String selectCartList = "select ct.cart_id, bk.booksid, bk.booksname, bk.authors, bk.publishers, bk.edition, bk.category, "
				+ "bk.act_rate, bk.book_image from cartdetails ct "
				+ "inner join bookdetails bk on ct.booksid = bk.booksid WHERE ct.username = ?";
		try {
			List<CartDetails> cartList = jdbcTemplate.query(selectCartList, new CartMapper(), userName);
			return cartList;
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public int deleteCart(int cartId) {
		String deleteCart = "DELETE FROM cartdetails WHERE cart_id = ?";
		try {
			int noOfRowsAffected = jdbcTemplate.update(deleteCart, cartId);
			return noOfRowsAffected;
		}catch (Exception e) {
			return 0;
		}
		
	}
	
	public int addOrder(OrdersDetails order) {
		String insertOrder = "insert into orderhistory(orderid, booksid, username, orderdate, quantity, totalprice, advanceamt, status)"
				+ "values(orderId.nextval, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Object[] orderData = {order.getBookId(), order.getUserName(), order.getOrderDate(), order.getQuantity(), order.getTotalPrice(), 
					order.getAdvanceAmount(), order.getStatus()};
			int noOfRowsAffected = jdbcTemplate.update(insertOrder, orderData);
			return noOfRowsAffected;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateOrder(int orderId, String status) {
		String updateOrder = "update orderhistory set status = ? where orderId = ?";
		try {
			int noOfRowsAffected = jdbcTemplate.update(updateOrder, orderId, status);
			return noOfRowsAffected;
		}catch (Exception e) {
			return 0;
		}
		
	}
}
