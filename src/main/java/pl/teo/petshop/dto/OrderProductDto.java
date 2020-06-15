package pl.teo.petshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductDto that = (OrderProductDto) o;
        return quantity == that.quantity &&
                Objects.equals(Id, that.Id) &&
                productDto.equals(that.productDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, productDto, quantity);
    }
}
