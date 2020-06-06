package pl.teo.petshop.dto;

import java.math.BigDecimal;

public class OrderProductDto {
    private Long Id;
    private ProductDto productDto;
    private int quantity;

    public OrderProductDto(ProductDto productDto, int quantity) {
        this.productDto = productDto;
        this.quantity = quantity;
    }
    public BigDecimal getSum(){
        return this.productDto.getPrice().multiply(BigDecimal.valueOf(this.quantity)) ;
    }

    public OrderProductDto() {
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
