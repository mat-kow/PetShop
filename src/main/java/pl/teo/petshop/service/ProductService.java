package pl.teo.petshop.service;

import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.dto.ProductDto;
import pl.teo.petshop.entity.Product;

import java.util.List;

public interface ProductService {
    void create (ProductDto productDto, MultipartFile image);
    ProductDto getById(Long id);
    Product mapDtoToProduct (ProductDto dto);
    ProductDto mapToDto (Product product);
    List<ProductDto> getAll();
}
