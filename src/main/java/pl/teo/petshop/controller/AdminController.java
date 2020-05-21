package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.repository.UserRepository;

@Controller
public class AdminController {
    private UserRepository userRepository;
    @Autowired
    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @RequestMapping("create")
//    public String createFirstAdmin(){
//        User user = new User("admin","admin1","ROLE_ADMIN",true, "q@q.q");
//        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//        userRepository.save(user);
//        return "redirect:home";
//    }
}
