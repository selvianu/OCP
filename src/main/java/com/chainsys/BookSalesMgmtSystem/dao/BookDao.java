package com.chainsys.BookSalesMgmtSystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Employees;
import com.chainsys.BookSalesMgmtSystem.model.Users;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate temp;

	public int addBooks(Books bk) {
		String q = "insert into bookDetails(booksId, booksName, authors, publishers, edition, language, category, price, mrp_rate, "
				+ "act_rate, avl_quantity) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { bk.getBookId(), bk.getBookName(), bk.getAuthor(), bk.getPublisher(), bk.getEdition(),
				bk.getCategory(),bk.getLanguage(), bk.getPrice(), bk.getMrpRate(), bk.getActPrice(), bk.getAvlQuantity()};// create the object for execute the query
		int flag = temp.update(q, data);// execute the query
		return flag;
	}
	
	
}
