package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.entity.UserDetails;
import pl.teo.petshop.repository.UserDetailsRepository;
import pl.teo.petshop.repository.UserRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Controller
public class UserDetController {
    private UserRepository userRepository;
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    public UserDetController(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @RequestMapping("details")
    public String details(){
        User user = new User("qwe", "qwe" , "ROLE_USER", true, "qq@q.q");
        UserDetails details = new UserDetails("qwe", "qwe", "qwe", "59-700", "qwe");
        user.setUserDetails(details);
        userDetailsRepository.save(details);
        userRepository.save(user);
        return "redirect:home";
    }
}
