package nc.onlinelibrary.mvc.web;

import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.domain.User;
import nc.onlinelibrary.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@Controller
public class HomeController {

	@Qualifier("bookService")
	@Autowired
	private BookService bookService;

	@RequestMapping("/")
	public String homePage(){
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String listBooks(Map<String, Object> map){
		map.put("book", new Book());
		map.put("user", SecurityContextHolder.getContext().getAuthentication().getName());
		map.put("listBook", bookService.listBook());
		return "books";
	}
	@RequestMapping(value = "/add" ,method = RequestMethod.GET)
	public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
		bookService.addBook(book);
		return "redirect:/index";
	}
	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.removeBook(bookId);
		return "redirect:/index";
	}

	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable("bookId") Integer bookId) {
		bookService.getBook(bookId);
		return "redirect:/index";
	}

	@RequestMapping("/return/{bookId}")
	public String returnBook(@PathVariable("bookId") Integer bookId) {
		bookService.returnBook(bookId);
		return "redirect:/index";
	}
}