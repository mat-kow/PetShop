package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.teo.petshop.dto.UserDetailsDto;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.service.UserService;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user")
    public String details(Model model) {
        UserDto user = userService.getCurrentUserDto();
        UserDetailsDto userDetailsDto = userService.getUserDetailsDto(user);
        model.addAttribute("userDetailsDto", userDetailsDto);
        return "user";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String setUserDetails(@Valid UserDetailsDto userDetailsDto, BindingResult result, Model model){
        if(result.hasErrors()){
            return "user";
        }
        userService.setDetailsForCurrentUser(userDetailsDto);
        model.addAttribute("successFlag", true);
        return "user";
    }
}
