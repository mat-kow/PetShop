package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {
    private UserRepository userRepository;

    @Autowired
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping({"", "/home"})
    public String home(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        Object user =authentication.getPrincipal();
        System.out.println(user.toString());
        return authentication.getName();
    }
}
