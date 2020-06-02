package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.entity.User;
import pl.teo.petshop.repository.ProductRepository;
import pl.teo.petshop.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {
    private ProductRepository productRepository;

    @Autowired
    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping({"", "/home"})
    public String home(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "index";
    }

}
