package com.chainsys.BookSalesMgmtSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.CartMapper;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;

@Repository
public class OrderDao {

	@Autowired
	JdbcTemplate temp;
	
	public int addcart(Cart cart) {
		String q = "INSERT INTO cartdetails(cart_id, username, booksid)values(cardId.nextval, ?, ?)";
		// create the object for execute the query
		Object[] data = {cart.getUserName(), cart.getBookId()};
		int flag = temp.update(q, data);// execute the query
		return flag;
	}
	
	public List<CartDetails> getCart(String userName){
		String q = "select ct.cart_id, bk.booksid, bk.booksname, bk.authors, bk.publishers, bk.edition, bk.category, "
				+ "bk.act_rate, bk.book_image from cartdetails ct "
				+ "inner join bookdetails bk on ct.booksid = bk.booksid WHERE ct.username = ?";
		try {
			List<CartDetails> cart = temp.query(q, new CartMapper(), userName);
			return cart;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
