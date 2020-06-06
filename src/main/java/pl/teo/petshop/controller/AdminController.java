package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_SALE");

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("admin")
    public String adminPage(Model model, @RequestParam(required = false) Boolean active, @RequestParam(required = false) Long id){
        if(active != null && id != null){
            userService.changeActive(active, id);
        }
        List<UserDto> users = userService.getAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        return "admin";
    }
    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String changeRole(@RequestParam String role, @RequestParam long id){
        userService.setRole(id, role);
        return "redirect:admin";
    }
}
