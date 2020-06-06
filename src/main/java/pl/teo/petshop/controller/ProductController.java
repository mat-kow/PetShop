package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.dto.ProductDto;
import pl.teo.petshop.service.FileService;
import pl.teo.petshop.service.ProductService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductService productService;
    private final FileService fileService;

    @Autowired
    public ProductController(ProductService productService,FileService fileService) {
        this.productService = productService;
        this.fileService = fileService;
    }

    @RequestMapping("newproduct")
    public String newProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/newProduct";
    }

    @RequestMapping(value = "newproduct", method = RequestMethod.POST)
    public String saveNewProduct(@Valid ProductDto productDto, BindingResult result, Model model,
                                 @RequestParam(required = false) MultipartFile image) {
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "product/newProduct";
        }
        model.addAttribute("successFlag", true);
        productService.create(productDto, image);
        return "redirect:home";
    }
    @RequestMapping("product")
    public String showProduct(Model model, @RequestParam(defaultValue = "0") long id){
        ProductDto productDto = productService.getById(id);
        model.addAttribute("productDto", productDto);
        return "product/product";
    }

    @RequestMapping(value = "file/images/{fileName}", method = RequestMethod.GET)
    public void getFile(@PathVariable String fileName, HttpServletResponse response) {
        fileName = "images/" + fileName;
        fileService.getFile(fileName, response);
    }
}
