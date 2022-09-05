package com.chainsys.BookSalesMgmtSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.BookMapper;
import com.chainsys.BookSalesMgmtSystem.mapper.UserMapper;
import com.chainsys.BookSalesMgmtSystem.model.Books;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate temp;

	public int addBooks(Books bk) {
		String q = "insert into bookDetails(booksId, booksName, authors, publishers, edition, category, language, price, mrp_rate, "
				+ "act_rate, avl_quantity, book_image) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { bk.getBookId(), bk.getBookName(), bk.getAuthor(), bk.getPublisher(), bk.getEdition(),
				bk.getCategory(), bk.getLanguage(), bk.getPrice(), bk.getMrpRate(), bk.getActPrice(),
				bk.getAvlQuantity(), bk.getImage() };// create the object for execute the query
		int flag = temp.update(q, data);// execute the query
		return flag;
	}

	public List<Books> getBookList() {
		String q = "select * from bookdetails";
		List<Books> bkList = null;
		try {
			bkList = temp.query(q, new BookMapper());
			return bkList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getNovels(){
		String q = "select * from bookdetails where category = 'Novel'";
		List<Books> novelList = null;
		try {
			novelList = temp.query(q, new BookMapper());
			return novelList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getPoetry(){
		String q = "select * from bookdetails where category = 'Poetry'";
		List<Books> PoetryList = null;
		try {
			PoetryList = temp.query(q, new BookMapper());
			return PoetryList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getHistory(){
		String q = "select * from bookdetails where category = 'History'";
		List<Books> historyList = null;
		try {
			historyList = temp.query(q, new BookMapper());
			return historyList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getEducation(){
		String q = "select * from bookdetails where category = 'Education'";
		List<Books> educList = null;
		try {
			educList = temp.query(q, new BookMapper());
			return educList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getBiography(){
		String q = "select * from bookdetails where category = 'Biography'";
		List<Books> bioList = null;
		try {
			bioList = temp.query(q, new BookMapper());
			return bioList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public Books editBookDetails(String id) {
		String q = "select * from bookdetails where booksid = ?";
		Books bk = null;
		try {
			bk = temp.queryForObject(q, new BookMapper(), id);			
		}catch (Exception e) {
			System.out.println("Exception");
		}
		return bk;
	}
	
	public int updateBookDetails(Books bk) {
		String q = "update bookdetails set booksid = ?, booksname =?, authors = ?, publishers = ?, edition = ?, price = ?, mrp_rate = ?,"
				+  "avl_quantity = ? where booksid = ?";
		Object[] bkData = {bk.getBookId(), bk.getBookName(), bk.getAuthor(), bk.getPublisher(), bk.getEdition(),
				bk.getPrice(), bk.getMrpRate(), bk.getAvlQuantity(), bk.getBookId()};
		int flag = temp.update(q, bkData);
		return flag;
	}
	
	public int deleteBook(String bkId) {
		String q = "DELETE FROM bookdetails WHERE booksId = ?";
		try {
			int flag = temp.update(q, bkId);
			return flag;
		}catch (Exception e) {
			return 0;
		}
	}
}
