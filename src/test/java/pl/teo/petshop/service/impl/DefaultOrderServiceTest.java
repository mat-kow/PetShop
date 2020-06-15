package pl.teo.petshop.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.dto.*;
import pl.teo.petshop.entity.*;
import pl.teo.petshop.repository.OrderProductRepository;
import pl.teo.petshop.repository.OrderRepository;
import pl.teo.petshop.service.DeliveryService;
import pl.teo.petshop.service.ProductService;
import pl.teo.petshop.service.UserService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultOrderServiceTest {
    @Mock
    private OrderProductRepository orderProductRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private UserService userService;
    @Mock
    private ProductService productService;
    @Mock
    private DeliveryService deliveryService;
    @InjectMocks
    private DefaultOrderService orderService;

    @Test
    void should_change_status_from_sent_to_delivered() {
        Order order = getOrder();
        order.setStatus(OrderStatus.SENT);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        orderService.changeStatusToNext(1L);

        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    void should_change_status_from_created_to_paid() {
        Order order = getOrder();
        order.setStatus(OrderStatus.CREATED);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        orderService.changeStatusToNext(1L);

        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test
    void should_change_status_from_paid_to_sent() {
        Order order = getOrder();
        order.setStatus(OrderStatus.PAID);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        orderService.changeStatusToNext(1L);

        assertEquals(OrderStatus.SENT, order.getStatus());
    }

    @Test
    void should_not_change_status_from_delivered() {
        Order order = getOrder();
        order.setStatus(OrderStatus.DELIVERED);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        orderService.changeStatusToNext(1L);

        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test
    void should_map_orderProduct_to_dto() {
        OrderProduct entity = getOrderProduct();
        OrderProductDto dto = getOrderProductDto();
        when(productService.mapToDto(any())).thenReturn(getProductDto());

        OrderProductDto mapped = orderService.mapOrderProductToDto(entity);

        assertEquals(dto, mapped);
    }

    @Test
    void should_map_dto_to_orderProduct() {
        OrderProduct entity = getOrderProduct();
        OrderProductDto dto = getOrderProductDto();
        when(productService.mapDtoToProduct(any())).thenReturn(getProduct());

        OrderProduct mapped = orderService.mapDtoToOrderProduct(dto);

        assertEquals(entity, mapped);
    }

    @Test
    void should_map_order_to_dto() {
        Order entity = getOrder();
        OrderDto dto = getOrderDto();
        when(userService.mapUserToDto(any())).thenReturn(getUserDto());
        when(deliveryService.mapToDto(any())).thenReturn(getDeliveryDto());
        when(productService.mapToDto(any())).thenReturn(getProductDto());

        OrderDto mapped = orderService.mapOrderToDto(entity);

        assertEquals(dto, mapped);
    }

    @Test
    void should_map_dto_to_order() {
        Order entity = getOrder();
        OrderDto dto = getOrderDto();
        when(userService.mapDtoToUser(any())).thenReturn(getUser());
        when(deliveryService.mapDtoToDelivery(any())).thenReturn(getDelivery());
        when(productService.mapDtoToProduct(any())).thenReturn(getProduct());

        Order mapped = orderService.mapDtoToOrder(dto);

        assertEquals(entity, mapped);
    }

    private Order getOrder(){
        Order entity = new Order();
        entity.setStatus(OrderStatus.SENT);
        entity.setDelivery(getDelivery());
        entity.setUser(getUser());
        entity.setProducts(Arrays.asList(getOrderProduct()));
        entity.setCreated(new Timestamp(123456789));
        entity.setId(789L);
        return entity;
    }
    
    private OrderDto getOrderDto(){
        OrderDto dto = new OrderDto();
        dto.setStatus(OrderStatus.SENT);
        dto.setDeliveryDto(getDeliveryDto());
        dto.setUserDto(getUserDto());
        dto.setProductsDto(Arrays.asList(getOrderProductDto()));
        dto.setCreated(new Timestamp(123456789));
        dto.setId(789L);
        return dto;
    }

    private User getUser(){
        User entity = new User("name","pass","ROLE_USER",true, "q@q.q");
        entity.setId(456L);
        return entity;
    }

    private UserDto getUserDto(){
        UserDto dto = new UserDto("name","pass","q@q.q",true, "ROLE_USER");
        dto.setId(456L);
        return dto;
    }

    private OrderProduct getOrderProduct(){
        OrderProduct entity = new OrderProduct(getProduct(), 5);
        entity.setId(452L);
        return entity;
    }
    
    private OrderProductDto getOrderProductDto(){
        OrderProductDto entity = new OrderProductDto(getProductDto(), 5);
        entity.setId(452L);
        return entity;
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

    private Delivery getDelivery(){
        Delivery delivery = new Delivery();
        delivery.setId(123L);
        delivery.setName("courier");
        delivery.setLabel("Kurier");
        delivery.setCost(BigDecimal.valueOf(456.23));
        return delivery;
    }

    private DeliveryDto getDeliveryDto() {
        DeliveryDto dto = new DeliveryDto();
        dto.setId(123L);
        dto.setName("courier");
        dto.setLabel("Kurier");
        dto.setCost(BigDecimal.valueOf(456.23));
        return dto;
    }
}