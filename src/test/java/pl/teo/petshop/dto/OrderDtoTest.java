package pl.teo.petshop.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class OrderDtoTest {
     private final OrderDto orderDto = new OrderDto();


    @Test
    void should_get_sum() {
        orderDto.setProductsDto(getProducts());
        orderDto.setDeliveryDto(new DeliveryDto("a","a", BigDecimal.valueOf(10)));
        BigDecimal expected = BigDecimal.valueOf(348.94);
        BigDecimal actual = orderDto.getSum();
        assertEquals(expected, actual);
        assertNotEquals(BigDecimal.valueOf(123), actual);

    }
    private List<OrderProductDto> getProducts () {
        ProductDto product1 = new ProductDto("Product 1");
        product1.setPrice(BigDecimal.valueOf(9.87));
        ProductDto product2 = new ProductDto("Product 2");
        product2.setPrice(BigDecimal.valueOf(96.53));
        OrderProductDto orderProductDto1 = new OrderProductDto(product1, 5);
        OrderProductDto orderProductDto2 = new OrderProductDto(product2, 3);
        return Arrays.asList(orderProductDto1, orderProductDto2);
    }
}