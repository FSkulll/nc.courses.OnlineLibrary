package nc.onlinelibrary.mvc.web;

import nc.onlinelibrary.mvc.domain.User;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @Qualifier("userService")
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String regPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {

        userService.addUser(user);
        return "redirect:/index";
    }

}
