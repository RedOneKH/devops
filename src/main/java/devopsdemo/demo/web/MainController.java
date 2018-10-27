package devopsdemo.demo.web;

import devopsdemo.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(Model model,@ModelAttribute User user) {
        System.out.printf(user.getUsername());
        model.addAttribute("error", true);
        String re;
        String res;
        String ress;
        return "login";
    }
}
