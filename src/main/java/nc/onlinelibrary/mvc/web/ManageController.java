package nc.onlinelibrary.mvc.web;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {

    @RequestMapping("/manage")
    private String managePage(Model model){
        model.addAttribute("appuser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "manage";
    }

}
