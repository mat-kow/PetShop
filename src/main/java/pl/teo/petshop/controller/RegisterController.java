package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.dto.UserDto;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.repository.UserRepository;
import pl.teo.petshop.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegisterController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getRegisterForm(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registration (@Valid UserDto user, BindingResult result, Model model,
                                @RequestParam String password2){
        if(result.hasErrors()){
            System.out.println(result.toString());
            return "register";
        }
        Optional<User> userDuplicated = userRepository.findByUserNameIgnoreCase(user.getUserName());//todo duplicated username
        if(userDuplicated.isPresent()){
            model.addAttribute("userNameFlag", true);
            return "register";
        }
        Optional<User> emailDuplicated = userRepository.findByEmailIgnoreCase(user.getEmail());//todo duplicated email
        if(emailDuplicated.isPresent()){
            model.addAttribute("emailFlag", true);
            return "register";
        }
        if(!user.getPassword().equals(password2)){//todo matching passwords
            model.addAttribute("password2Flag", true);
            return "register";
        }
        userService.createNewUser(user);
        return "redirect:home";
    }

    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
