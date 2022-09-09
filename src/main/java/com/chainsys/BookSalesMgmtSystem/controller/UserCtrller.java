package com.chainsys.BookSalesMgmtSystem.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.UserDao;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;
import com.chainsys.BookSalesMgmtSystem.model.OrdersDetails;
import com.chainsys.BookSalesMgmtSystem.model.Users;
import com.chainsys.BookSalesMgmtSystem.service.OrderService;
import com.chainsys.BookSalesMgmtSystem.service.UserService;

@Controller
public class UserCtrller {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/signup")
	public String signup(@RequestParam("username") String userName, @RequestParam("email") String email, @RequestParam("pwd") String password, Model model, HttpServletRequest request) {
		
		try {
			
			if(userDao.checkUserNameAvail(userName)) {
				Users user = new Users();
				user.setUserName(userName);
				user.setPassword(password);
				user.setEmailId(email);
				int noOfRowsAffected = userDao.signup(user);
				if(noOfRowsAffected > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("user", userName);
					return "userBooks";
				}
				else {
					model.addAttribute("msg", "Some internal problem Please try again later");
					return "signup.jsp";
				}
			}
			else {
				model.addAttribute("msg", "Username is already exists!. Please click login! or Try with another Username");
				return "signup.jsp";
			}
			
			
		}catch (Exception e) {
			model.addAttribute("msg", "Some internal problem Please try again later");
			return "signin.jsp";
		}
	}
	
	
	@GetMapping("/userlogin")
	public String login(@RequestParam("username") String uname, @RequestParam("pwd") String pwd, Model model, HttpServletRequest request) {
		
		try {
			if(userDao.login(uname, pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", uname);
				return "userBooks";
			}
			else {
				model.addAttribute("msg", "Invalid username or password. Please check your username and password");
				return "login.jsp";
			}
		}catch (Exception e) {
			model.addAttribute("msg", "Some internal problem! Please try again later!");
			return "login.jsp";
		}
	}
	
	@GetMapping("/changepassword")
	public String updatePassword(@RequestParam("username") String username, @RequestParam("pwd2") String password2,
			@RequestParam("pwd1") String password1, Model model) {
		if(password1.equals(password2)) {
			if(userService.updatePassword(username, password2)) {
				model.addAttribute("msg", "Your password is changed! Please login to the system!");
				return "login.jsp";
			}
			else {
				model.addAttribute("msg", "Invalid username! Please check your username");
				return "forgotpassword.jsp";
			}
		}
		else {
			model.addAttribute("msg", "The Change password and Conform Password should be same!");
			return "forgotpassword.jsp";
		}
		
	}
	
	@GetMapping("/userBooks")
	public String getTopBooks(Model model) {
		List<Books> topBooks = userService.getTopBooks();
		List<Books> bookList = userService.getBooks();
		model.addAttribute("books", bookList);
		model.addAttribute("topBooks", topBooks);
		return "user_landing.jsp";
	}
	
	@GetMapping("/getAllBooks")
	public String getAllBooks(Model model) {
		List<Books> bookList = userService.getBooks();
		model.addAttribute("books", bookList);
		return "allbooks.jsp";
	}
	
	@GetMapping("/userNovels")
	public String getNovels(Model model) {
		List<Books> novels = userService.getNovelBooks();
		if(novels != null) {
			model.addAttribute("books", novels);
			return "user_landing.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "user_landing.jsp";
		}
	}
	
	@GetMapping("/userPoetry")
	public String getPoetry(Model model) {
		List<Books> poetry = userService.getPoetryBooks();
		if(poetry != null) {
			model.addAttribute("books", poetry);
			return "user_landing.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "user_landing.jsp";
		}
	}
	
	@GetMapping("/userHistory")
	public String getHistory(Model model) {
		List<Books> history = userService.getHistoryBooks();
		if(history != null) {
			model.addAttribute("books", history);
			return "user_landing.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "user_landing.jsp";
		}
	}
	
	@GetMapping("/userEducation")
	public String getEducation(Model model) {
		List<Books> education = userService.getEducationBooks();
		if(education != null) {
			model.addAttribute("books",education);
			return "user_landing.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "user_landing.jsp";
		}
	}
	
	@GetMapping("/userBiography")
	public String getBiography(Model model) {
		List<Books> biography = userService.getBiographyBooks();
		if(biography != null) {
			model.addAttribute("books", biography);
			return "user_landing.jsp";
		}
		else {
			model.addAttribute("msg", "There is no Books are available now");
			return "user_landing.jsp";
		}
	}
	
	@GetMapping("/getBooks")
	public String getBuys(@RequestParam("id") String bkId, @RequestParam("cat") String category, Model model) {
		Books books = userService.getBookById(bkId);
		List<Books> categoryBooks = userService.getBookBycategory(category);
		List<Books> topBooks = userService.getTopBooks();
		model.addAttribute("book", books);
		model.addAttribute("topBooks", topBooks);
		model.addAttribute("relatedBook", categoryBooks);
		return "viewbook.jsp";
	}
	
	@GetMapping("/searchBooks")
		public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
			List<Books> searchedBooks = userService.searchBooks(keyword);
			if(searchedBooks == null || searchedBooks.isEmpty()) {
				model.addAttribute("msg", "No Books");
				return "allbooks.jsp";
			}
			else {
				model.addAttribute("books", searchedBooks);
				return "allbooks.jsp";
			}
		}
	
	@GetMapping("/user")
	public String userPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "userBooks";
	}
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("id") String cartId, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		if(userName == null) {
			return "login.jsp";
		}
		else {
			Cart cart = new Cart();
			cart.setUserName(userName);
			cart.setBookId(cartId);
			if(userService.addToCart(cart)) {
				model.addAttribute("msg", "Added Successfully");
				return "getBooks";
			}
			else {
				model.addAttribute("msg", "Some Internal Problem. Please try again later!");
				return "getBooks";
			}
		}
	}
	
	@GetMapping("/carts")
	public String getCartDetails(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		List<CartDetails> carts = userService.getCart(userName);
		if(carts == null || carts.isEmpty()) {
			model.addAttribute("msg", "No Carts");
			return "cartpage.jsp";
		}
		else {
			model.addAttribute("carts", carts);
			return "cartpage.jsp";
		}
	}
	
	@GetMapping("/deletecart")
	public String deleteCart(@RequestParam("id") int cartId, Model model) {
		if(userService.deleteCart(cartId)) {
			model.addAttribute("msg", "The item is successfully removed from the cart!");
			return "carts";
		}
		else {
			model.addAttribute("msg", "You can't remove the item now. Please try again later! ");
			return "carts";
		}
	}
	
	@GetMapping("/getOrders")
	public String getOrder(HttpServletResponse response, HttpServletRequest request, Model model, @RequestParam("id") String bookId) {
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("user");
		session.setAttribute("id", bookId);
		if(uname.equals(null)) {
			model.addAttribute("msg", "Please login our system to order the books");
			return "login.jsp";
		}
		else {
			Users user = userDao.getUserById(uname);
			model.addAttribute("userdata", user);
			model.addAttribute("msg", "Please check your personal details");
			return "profile.jsp";
		}
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("name") String name,@RequestParam("phno") String phno, @RequestParam("addr") String address, 
			@RequestParam("dist") String district, @RequestParam("state") String state,
			@RequestParam("pincode") int pincode, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		Users user = new Users();
		user.setUserName(username);
		user.setName(name);
		user.setPhoneno(phno);
		user.setAddress(address);
		user.setDistrict(district);
		user.setState(state);
		user.setPincode(pincode);
		
		userDao.upadteUser(user);
		return "placeOrders";
	}
	
	@GetMapping("/placeOrders")
	public String placeOrders(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
		String bookId = (String) session.getAttribute("id");
		Books book = userService.getBookById(bookId);
		model.addAttribute("book", book);
		return "buy.jsp";
	}
	
//	@RequestParam("bookid") String bookId, @RequestParam("bookName") String bookName, @RequestParam("author") String author,
//	@RequestParam("publisher") String publisher, @RequestParam("price") int price, @RequestParam("quantity") int quantity, @RequestParam("total") int totalPrice
	
	@GetMapping("/placeOrder")
	public String addOrder(HttpServletRequest request, Model model, @RequestParam("bookid") String bookId, @RequestParam("quantity") int quantity, @RequestParam("total") int totalPrice, @RequestParam("advanceAmount") int advanceAmount) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		
		LocalDate localDate = LocalDate.now();
		Date orderedDate = Date.valueOf(localDate);
		
		OrdersDetails order = new OrdersDetails();
		order.setBookId(bookId);
		order.setUserName(userName);
		order.setQuantity(quantity);
		order.setOrderDate(orderedDate);
		order.setTotalPrice(totalPrice);
		order.setAdvanceAmount(advanceAmount);
		order.setStatus("Ordered");
		
		if(orderService.addOrder(order)) {
			model.addAttribute("msg", "Your Order is Placed Successfully!");
			return "userBooks";
		}
		else {
			model.addAttribute("msg", "Some Internal Problem may occur. Please try again later!");
			return "buy.jsp";
		}
	}
	
	@GetMapping("/cancel")
	public String cancelBook(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		return "userBooks";
	}
}
