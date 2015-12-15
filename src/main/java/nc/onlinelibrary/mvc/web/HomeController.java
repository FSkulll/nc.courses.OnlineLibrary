package nc.onlinelibrary.mvc.web;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.Users;
import nc.onlinelibrary.mvc.service.BookService;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@Secured("ROLE_ADMIN")
	public String listBooks(Map<String, Object> map){
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		map.put("listBook", bookService.listBook());
		return "books";
	}

	@RequestMapping("/show/{bookId}")
	public String showBook(@PathVariable("bookId") Integer bookId, Map<String, Object> map) {
		map.put("book",bookService.getBook(bookId));
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return "show_info";
	}

	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable("bookId") Integer bookId) {
		Book book = bookService.getBookIssue(bookId);
		Users user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		userService.addBookToList(user, book);
		bookService.setAvailable(bookId, false);
		return "redirect:/index";
	}

	@RequestMapping("/return/{bookId}")
	public String returnBook(@PathVariable("bookId") Integer bookId) {
		Users user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		bookService.returnBook(bookId, user);

		return "redirect:/";
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchBook(@RequestParam("str") String str) {
		ModelAndView view = new ModelAndView("books");
		Map<String, Object> map = view.getModelMap();
		map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		map.put("listBook", bookService.searchBook(str));
		return view;
	}
}