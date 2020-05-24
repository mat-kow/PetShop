package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.repository.ProductRepository;

import javax.validation.Valid;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("newproduct")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "newProduct";
    }
    @RequestMapping(value = "newproduct", method = RequestMethod.POST)
    public String saveNewProduct(@Valid Product product, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newProduct";
        }
        productRepository.save(product);
        model.addAttribute("successFlag",true);
        return "redirect:newproduct";
    }

}
