package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.exception.UserNotFoundException;
import pl.teo.petshop.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_SALE");

    @Autowired
    public AdminController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("create")
    public String createFirstAdmin(){
        User user = new User("admin","admin1","ROLE_ADMIN",true, "q@q.q");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:home";
    }

    @RequestMapping("admin")
    public String adminPage(Model model, @RequestParam Optional<Boolean> active, @RequestParam Optional<Long> id){
        if(active.isPresent() && id.isPresent()){
            Optional<User> userOptional = userRepository.findById(id.get());
            User user = userOptional.orElseThrow(() -> new UserNotFoundException(id.get()));
            user.setActive(active.get());
            userRepository.save(user);
        }
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        return "admin";
    }
    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String changeRole(@RequestParam String role, @RequestParam long id){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(id));
        user.setRoles(role);
        userRepository.save(user);
        return "redirect:admin";
    }
}
