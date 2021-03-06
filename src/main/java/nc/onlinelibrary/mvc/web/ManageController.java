package nc.onlinelibrary.mvc.web;


import nc.onlinelibrary.mvc.domain.Book;
import nc.onlinelibrary.mvc.service.BookService;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ManageController {


    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/manage")
    @Secured("ROLE_ADMIN")
    private String managePage(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "manage";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/books_list")
    private String listBooks(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        map.put("listBook", bookService.listBook());
        return "books_list";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/create_book")
    private String createBook(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        map.put("book", new Book());
        return "addbook";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult) {
        bookService.addBook(book);
        return "redirect:/books_list";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId) {
        bookService.removeBook(bookId);
        return "redirect:/books_list";
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping("/users_list")
    private String listUsers(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        map.put("listUsers", userService.listUsers());
        return "users_list";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/remove/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return "redirect:/users_list";
    }

}
