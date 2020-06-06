package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.petshop.dto.ProductDto;
import pl.teo.petshop.service.ProductService;

import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"", "/home"})
    public String home(Model model){
        List<ProductDto> products = productService.getAll();
        model.addAttribute("products", products);
        return "index";
    }

}
