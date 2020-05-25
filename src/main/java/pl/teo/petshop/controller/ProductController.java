package pl.teo.petshop.controller;

import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.entity.FileMetadata;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.repository.FileMetadataRepository;
import pl.teo.petshop.repository.ProductRepository;
import pl.teo.petshop.service.AwsFileService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    private AwsFileService fileService;
    private FileMetadataRepository fileMetadataRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, AwsFileService fileService, FileMetadataRepository fileMetadataRepository) {
        this.productRepository = productRepository;
        this.fileService = fileService;
        this.fileMetadataRepository = fileMetadataRepository;
    }

    @RequestMapping("newproduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "newProduct";
    }

    @RequestMapping(value = "newproduct", method = RequestMethod.POST)
    public String saveNewProduct(@Valid Product product, BindingResult result, Model model,
                                 @RequestParam Optional<MultipartFile> image) {
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "newProduct";
        }
        model.addAttribute("successFlag", true);
        if(image.isPresent()){
            product.setImageMeta(fileService.uploadFile(image.get()));
        }
        productRepository.save(product);
        return "redirect:home";
    }

    @RequestMapping(value = "file/images/{fileName}", method = RequestMethod.GET)
    public void getFile(@PathVariable String fileName, HttpServletResponse response) {
        fileName = "images/" + fileName;
        try {
            S3Object object = fileService.getFile(fileName);
            InputStream is = object.getObjectContent();
            FileMetadata metadata = (fileMetadataRepository.findByName(fileName)).get();//todo orElseThrow
            response.setContentType(metadata.getContentType());
            response.setContentLength((int) metadata.getSize());
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            System.out.println("Download file error " + ex);
            response.setStatus(404);
        }
    }
}
