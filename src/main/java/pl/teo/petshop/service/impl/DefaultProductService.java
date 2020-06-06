package pl.teo.petshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.dto.ProductDto;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.ProductRepository;
import pl.teo.petshop.service.FileService;
import pl.teo.petshop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;
    private final FileService fileService;

    @Autowired
    public DefaultProductService(ProductRepository productRepository, FileService fileService) {
        this.productRepository = productRepository;
        this.fileService = fileService;
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void create(ProductDto productDto, MultipartFile image) {
        Product product = mapDtoToProduct(productDto);
        if(image != null){
            product.setImageMeta(fileService.uploadFile(image));
        }
        productRepository.save(product);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapToDto(product);
    }

    @Override
    public Product mapDtoToProduct (ProductDto dto){
        Product product = new Product();
        if(dto.getId() != null) {
            product.setId(dto.getId());
        }
        product.setImageMeta(dto.getImageMeta());
        product.setActive(dto.isActive());
        product.setCategories(dto.getCategories());
        product.setDescription(dto.getDescription());
        product.setEan(dto.getEan());
        product.setManufacturer(dto.getManufacturer());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setSupplier(dto.getSupplier());
        product.setWeightGrams(dto.getWeightGrams());
        product.setImageMeta(dto.getImageMeta());
        return product;
    }

    @Override
    public ProductDto mapToDto (Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setActive(product.isActive());
        productDto.setCategories(product.getCategories());
        productDto.setDescription(product.getDescription());
        productDto.setEan(product.getEan());
        productDto.setId(product.getId());
        productDto.setImageMeta(product.getImageMeta());
        productDto.setManufacturer(product.getManufacturer());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setSupplier(product.getSupplier());
        productDto.setWeightGrams(product.getWeightGrams());
        return productDto;
    }
}
