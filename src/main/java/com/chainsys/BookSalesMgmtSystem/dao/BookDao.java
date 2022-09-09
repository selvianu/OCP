package com.chainsys.BookSalesMgmtSystem.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.BookSalesMgmtSystem.mapper.BookMapper;
import com.chainsys.BookSalesMgmtSystem.model.Books;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addBooks(Books books) {
		String insertBook = "insert into bookDetails(booksId, booksName, authors, publishers, edition, category, language, price, mrp_rate, "
				+ "act_rate, avl_quantity, book_image) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] bookData = { books.getBookId(), books.getBookName(), books.getAuthor(), books.getPublisher(), books.getEdition(),
				books.getCategory(), books.getLanguage(), books.getPrice(), books.getMrpRate(), books.getActualPrice(),
				books.getAvailableQuantity(), books.getBookImage() };// create the object for execute the query
		int noOfRowsAffected = jdbcTemplate.update(insertBook, bookData);// execute the query
		return noOfRowsAffected;
	}

	public List<Books> getBookList() {
		String selectBooks = "select * from bookdetails";
		List<Books> bookList = null;
		try {
			bookList = jdbcTemplate.query(selectBooks, new BookMapper());
			return bookList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getNovelBooks(){
		String selectNovelBooks = "select * from bookdetails where category = 'Novel'";
		List<Books> novelList = null;
		try {
			novelList = jdbcTemplate.query(selectNovelBooks, new BookMapper());
			return novelList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getPoetryBooks(){
		String selectPoetryBooks = "select * from bookdetails where category = 'Poetry'";
		List<Books> PoetryList = null;
		try {
			PoetryList = jdbcTemplate.query(selectPoetryBooks, new BookMapper());
			return PoetryList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getHistoryBooks(){
		String selctHistoryBooks = "select * from bookdetails where category = 'History'";
		List<Books> historyList = null;
		try {
			historyList = jdbcTemplate.query(selctHistoryBooks, new BookMapper());
			return historyList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getEducationBooks(){
		String selectEducationBooks = "select * from bookdetails where category = 'Education'";
		List<Books> educationList = null;
		try {
			educationList = jdbcTemplate.query(selectEducationBooks, new BookMapper());
			return educationList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getBiographyBooks(){
		String selectBiographyBooks = "select * from bookdetails where category = 'Biography'";
		List<Books> biographyList = null;
		try {
			biographyList = jdbcTemplate.query(selectBiographyBooks, new BookMapper());
			return biographyList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Books> getTopSaledBooks(){
		String selectTopSaledBooks = "select booksid from (SELECT booksid, COUNT(*)"
				+ "FROM orderhistory GROUP BY booksid ORDER BY booksid) WHERE ROWNUM <= 3";
		List<String> topBooks = null;
		try {
			topBooks = jdbcTemplate.queryForList(selectTopSaledBooks, String.class);
			List<Books> topbookList = topBooks.stream().map(bk -> getBookById(bk)).collect(Collectors.toList());
			return topbookList;
		}catch (Exception e) {
			return null;
		}
	}
	
	public Books getBookById(String bkId) {
		String selectBookById = "select * from bookdetails where booksid = ?";
		Books books = null;
		try {
			books = jdbcTemplate.queryForObject(selectBookById, new BookMapper(), bkId);
			return books;
		}catch (Exception e) {
			return null;
		}
	}
	
	public int updateBookDetails(Books books) {
		String updateBooks = "update bookdetails set booksid = ?, booksname =?, authors = ?, publishers = ?, edition = ?, price = ?, mrp_rate = ?,"
				+  "avl_quantity = ? where booksid = ?";
		Object[] bookData = {books.getBookId(), books.getBookName(), books.getAuthor(), books.getPublisher(), books.getEdition(),
				books.getPrice(), books.getMrpRate(), books.getAvailableQuantity(), books.getBookId()};
		int noOfRowsAffected = jdbcTemplate.update(updateBooks, bookData);
		return noOfRowsAffected;
	}
	
	public int deleteBook(String bkId) {
		String deleteBook = "DELETE FROM bookdetails WHERE booksId = ?";
		try {
			int noOfRowsAffected = jdbcTemplate.update(deleteBook, bkId);
			return noOfRowsAffected;
		}catch (Exception e) {
			return 0;
		}
	}
	
	public List<Books> searchBooks(String keyword){
		String selectByName = "select * from bookdetails where booksname = ?";
		String selectByAuthors = "select * from bookdetails where authors = ?";
		String selectByPublishers = "select * from bookdetails where publishers = ?";
		List<Books> searchedBooks = null;
		try {
			searchedBooks = jdbcTemplate.query(selectByName, new BookMapper(), keyword);
			if(searchedBooks.isEmpty()) {
				searchedBooks = jdbcTemplate.query(selectByAuthors, new BookMapper(), keyword);
				if(searchedBooks.isEmpty()) {
					searchedBooks = jdbcTemplate.query(selectByPublishers, new BookMapper(), keyword);
					if(searchedBooks.isEmpty()) {
						return null;
					}
					else {
						return searchedBooks;
					}
				}
				else {
					return searchedBooks;
				}
			}
			else {
				return searchedBooks;
			}
			
		}catch (Exception e) {
			return null;
		}
	}
	
	public int updateQuantity(int quantity, String bookId) {
		String updatequantity = "update bookdetails set avl_quantity = ? where booksid = ?";
		try {
			int noOfAffectedRows = jdbcTemplate.update(updatequantity, quantity, bookId);
			return noOfAffectedRows;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getQuantityById(String bookId) {
		String selectQuantity = "select avl_quantity from bookdetails where booksid = ?";
		try {
			int quantity = jdbcTemplate.queryForObject(selectQuantity, int.class, bookId);
			return quantity;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
