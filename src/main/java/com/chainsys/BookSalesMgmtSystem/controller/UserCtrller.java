package com.chainsys.BookSalesMgmtSystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.BookSalesMgmtSystem.dao.UserDoa;
import com.chainsys.BookSalesMgmtSystem.model.Books;
import com.chainsys.BookSalesMgmtSystem.model.Cart;
import com.chainsys.BookSalesMgmtSystem.model.CartDetails;
import com.chainsys.BookSalesMgmtSystem.model.Users;
import com.chainsys.BookSalesMgmtSystem.service.UserService;

@Controller
public class UserCtrller {

	@Autowired
	Users us;
	
	@Autowired
	UserDoa usdoa;
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/signin")
	public String signup(@RequestParam("username") String uname, @RequestParam("email") String email, @RequestParam("pwd") String pwd, Model model, HttpServletRequest request) {
		
		try {
			
			if(usdoa.checkUserNameAvail(uname)) {
				us.setUserName(uname);
				us.setPassword(pwd);
				us.setEmailId(email);
				int f = usdoa.signin(us);
				if(f > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("user", uname);
					return "userBooks";
				}
				else {
					model.addAttribute("msg", "Some internal problem Please try again later");
					return "signin.jsp";
				}
			}
			else {
				model.addAttribute("msg", "Username is already exists!. Please click login! or Try with another Username");
				return "signin.jsp";
			}
			
			
		}catch (Exception e) {
			model.addAttribute("msg", "Some internal problem Please try again later");
			return "signin.jsp";
		}
	}
	
	
	@GetMapping("/userlogin")
	public String login(@RequestParam("username") String uname, @RequestParam("pwd") String pwd, Model model, HttpServletRequest request) {
		
		try {
			if(usdoa.login(uname, pwd)) {
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
		}
		return "success";
	}
	
	@GetMapping("/userBooks")
	public String getTopBooks(Model model) {
		List<Books> topBks = uservice.getTopBooks();
		List<Books> bkList = uservice.getBooks();
		model.addAttribute("books", bkList);
		model.addAttribute("topBooks", topBks);
		return "user_landing.jsp";
	}
	
	@GetMapping("/userNovels")
	public String getNovels(Model model) {
		List<Books> novels = uservice.getNovels();
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
		List<Books> poetry = uservice.getPoetry();
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
		List<Books> history = uservice.getHistory();
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
		List<Books> education = uservice.getEducation();
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
		List<Books> biography = uservice.getBiography();
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
		Books bk = uservice.getBookById(bkId);
		List<Books> categoryBook = uservice.getBookBycategory(category);
		List<Books> topBks = uservice.getTopBooks();
		model.addAttribute("book", bk);
		model.addAttribute("topBooks", topBks);
		model.addAttribute("relatedBook", categoryBook);
		return "viewbook.jsp";
	}
	
	@GetMapping("/user")
	public String userPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		return "userBooks";
	}
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("id") String id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("user");
		if(uname == null) {
			return "login.jsp";
		}
		else {
			Cart cart = new Cart();
			cart.setUserName(uname);
			cart.setBookId(id);
			if(uservice.addToCart(cart)) {
				model.addAttribute("msg", "Added Successfully");
				return "getBooks";
			}
			else {
				
			}
		}
		return null;
	}
	
	@GetMapping("/carts")
	public String getCartDetails(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("user");
		List<CartDetails> carts = uservice.getCart(uname);
		if(carts == null) {
			model.addAttribute("msg", "No Carts");
			return "cartpage.jsp";
		}
		else {
			model.addAttribute("carts", carts);
			return "cartpage.jsp";
		}
	}
}
