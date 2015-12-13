package nc.onlinelibrary.mvc.web;

import nc.onlinelibrary.mvc.domain.Users;
import nc.onlinelibrary.mvc.service.BookService;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AccountController {

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @Qualifier("bookService")
    @Autowired
    private BookService bookService;

    @RequestMapping("/register")
    public String regPage(Model model){
        model.addAttribute("user", new Users());
        return "register";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    public String addUser(@Valid Users user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "register";
        userService.addUser(user);
        return "redirect:/index";
    }

    @RequestMapping("/reading_list")
    public String readingList(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        map.put("listIssue", userService.getUserIssue(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "reading_list";
    }
}
