package pl.teo.petshop.service;

import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.dto.OrderDto;
import pl.teo.petshop.dto.OrderProductDto;
import pl.teo.petshop.entity.Order;
import pl.teo.petshop.entity.OrderProduct;

import java.util.List;

public interface OrderService {
    long save(OrderDto orderDto);
    void changeStatusToNext(Long orderId);
    List<OrderDto> getAllByStatus(OrderStatus status);
    OrderDto getById(Long id);
    OrderProduct mapDtoToOrderProduct(OrderProductDto dto);
    OrderProductDto mapOrderProductToDto(OrderProduct orderProduct);
    Order mapDtoToOrder(OrderDto dto);
    OrderDto mapOrderToDto (Order order);
}
