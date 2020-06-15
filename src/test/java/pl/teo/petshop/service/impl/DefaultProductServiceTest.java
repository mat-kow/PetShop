package pl.teo.petshop.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.teo.petshop.dto.ProductDto;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.repository.ProductRepository;
import pl.teo.petshop.service.FileService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DefaultProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private FileService fileService;
    @InjectMocks
    private DefaultProductService productService;

    @Test
    void should_map_dto_to_product() {
        Product entity = getProduct();
        ProductDto dto = getProductDto();
        assertEquals(entity, productService.mapDtoToProduct(dto));
    }

    @Test
    void should_map_to_dto() {
        Product entity = getProduct();
        ProductDto dto = getProductDto();
        assertEquals(dto, productService.mapToDto(entity));
    }

    @Test
    void should_map_to_dto_with_only_name_field() {
        Product entity = new Product();
        entity.setName("Dogfood");
        ProductDto dto = new ProductDto();
        dto.setName("Dogfood");
        assertEquals(dto, productService.mapToDto(entity));
    }

    @Test
    void should_map_dto_to_product_with_only_name_field() {
        Product entity = new Product();
        entity.setName("Dogfood");
        ProductDto dto = new ProductDto();
        dto.setName("Dogfood");
        assertEquals(entity, productService.mapDtoToProduct(dto));
    }

    private Product getProduct(){
        Product entity = new Product();
        entity.setSupplier("supplier");
        entity.setPrice(new BigDecimal("123.45"));
        entity.setName("Product name");
        entity.setManufacturer("producer");
        entity.setEan("1234567890123");
        entity.setDescription("some description");
        entity.setCategories("some categories");
        entity.setActive(true);
        entity.setId(45L);
        entity.setStock(15);
        entity.setWeightGrams(500);
        return entity;
    }

    private ProductDto getProductDto(){
        ProductDto dto = new ProductDto();
        dto.setSupplier("supplier");
        dto.setPrice(new BigDecimal("123.45"));
        dto.setName("Product name");
        dto.setManufacturer("producer");
        dto.setEan("1234567890123");
        dto.setDescription("some description");
        dto.setCategories("some categories");
        dto.setActive(true);
        dto.setId(45L);
        dto.setStock(15);
        dto.setWeightGrams(500);
        return dto;
    }
}