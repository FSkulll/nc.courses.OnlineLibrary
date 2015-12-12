package nc.onlinelibrary.mvc.web;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.User;
import nc.onlinelibrary.mvc.service.BookService;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	@Qualifier("bookService")
	@Autowired
	private BookService bookService;

	@Qualifier("userService")
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String homePage(){
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Map<String, Object> map){
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return "index";
	}


	@RequestMapping("/books")
	public String listBooks(Map<String, Object> map){
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		map.put("listBook", bookService.listBook());
		return "books";
	}

	@RequestMapping("/show/{bookId}")
	public String showBook(@PathVariable("bookId") Integer bookId) {
		bookService.getBook(bookId);
		return "show_info";
	}

	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable("bookId") Integer bookId) {
		Book book = bookService.getBookWithRead(bookId);
		User user = userService.getUserWithReadList(SecurityContextHolder.getContext().getAuthentication().getName());
		userService.addToReadList(book, user.getUsername());
		book.setIsAvailable(false);
		return "redirect:/index";
	}

	@RequestMapping("/return/{bookId}")
	public String returnBook(@PathVariable("bookId") Integer bookId) {
		bookService.returnBook(bookId);
		return "redirect:/index";
	}
}