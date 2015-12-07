package nc.onlinelibrary.mvc.web;


import nc.onlinelibrary.mvc.dao.UserDAO;
import nc.onlinelibrary.mvc.domain.User;
import nc.onlinelibrary.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ManageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/manage")
    private String managePage(Map<String, Object> map){
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "manage";
    }

}
