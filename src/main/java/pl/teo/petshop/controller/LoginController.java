package pl.teo.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }
}
