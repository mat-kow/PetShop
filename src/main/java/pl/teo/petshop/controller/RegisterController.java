package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getRegisterForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registration (@Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.toString());
            return "register";
        }
        userService.createNewUser(userDto);
        return "afterRegister";
    }

    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping("/verify")
    public String verify(@RequestParam String uuid, @RequestParam Long id) {
        if (uuid != null && id != null) {
            if (userService.verify(id, uuid)) {
                return "successValidation";
            }
        }
        return "redirect:../../home";
    }

}
