package pl.teo.petshop.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderProductDtoTest {

    @Test
    void should_get_correct_sum() {
        OrderProductDto entity = new OrderProductDto(getProductDto(), 5);
        assertEquals(BigDecimal.valueOf(55.55), entity.getSum());
        assertNotEquals(BigDecimal.valueOf(55.54), entity.getSum());

    }

    private ProductDto getProductDto(){
        ProductDto p = new ProductDto("name");
        p.setPrice(BigDecimal.valueOf(11.11));
        return p;
    }
}