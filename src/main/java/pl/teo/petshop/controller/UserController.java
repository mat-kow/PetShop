package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.entity.UserDetails;
import pl.teo.petshop.exception.UserNotFoundException;
import pl.teo.petshop.repository.UserDetailsRepository;
import pl.teo.petshop.repository.UserRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


@Controller
public class UserController {
    private UserRepository userRepository;
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    public UserController(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @RequestMapping("user")
    public String details(Model model, Principal principal) {
        Optional<User> user = userRepository.findByUserNameIgnoreCase(principal.getName());
        UserDetails userDetails = user.get().getUserDetails();
        if(userDetails == null)   {
            userDetails = new UserDetails();
        }
        model.addAttribute("userDetails", userDetails);
        return "user";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String setUserDetails(@Valid UserDetails userDetails, BindingResult result, Principal principal, Model model){
        if(result.hasErrors()){
            System.out.println(result.toString());
            return "user";
        }
        userDetailsRepository.save(userDetails);
        Optional<User> userOptional = userRepository.findByUserName(principal.getName());
        User user = userOptional.orElseThrow(() -> new UserNotFoundException());
        user.setUserDetails(userDetails);
        userRepository.save(user);
        model.addAttribute("successFlag", true);
        return "user";
    }
}
