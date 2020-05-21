package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.repository.UserRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegisterController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String getRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registration (@Valid User user, BindingResult result, Model model,
                                @RequestParam String password2){
        if(result.hasErrors()){
            System.out.println(result.toString());
            return "register";
        }
        Optional<User> userDuplicated = userRepository.findByUserNameIgnoreCase(user.getUserName());
        if(userDuplicated.isPresent()){
            model.addAttribute("userNameFlag", true);
            return "register";
        }
        Optional<User> emailDuplicated = userRepository.findByEmailIgnoreCase(user.getEmail());
        if(emailDuplicated.isPresent()){
            model.addAttribute("emailFlag", true);
            return "register";
        }
        if(!user.getPassword().equals(password2)){
            model.addAttribute("password2Flag", true);
            return "register";
        }
        user.setPassword(passwordEncoder.encode(password2));
        userRepository.save(user);
        return "redirect:home";
    }
}
