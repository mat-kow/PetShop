package pl.teo.petshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.dto.OrderDto;
import pl.teo.petshop.dto.OrderProductDto;
import pl.teo.petshop.entity.Order;
import pl.teo.petshop.entity.OrderProduct;
import pl.teo.petshop.entity.Product;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.OrderProductRepository;
import pl.teo.petshop.repository.OrderRepository;
import pl.teo.petshop.service.DeliveryService;
import pl.teo.petshop.service.OrderService;
import pl.teo.petshop.service.ProductService;
import pl.teo.petshop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultOrderService implements OrderService {
    private final OrderProductRepository orderProductRepository;
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;
    private final DeliveryService deliveryService;


    @Autowired
    public DefaultOrderService( DeliveryService deliveryService, OrderProductRepository orderProductRepository,
                                OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderProductRepository = orderProductRepository;
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    @Transactional
    @Override
    public long save(OrderDto orderDto) {
        Order order = mapDtoToOrder(orderDto);
        order.setStatus(OrderStatus.CREATED);
        Product product1 = order.getProducts().get(0).getProduct();
        System.out.println(product1.getId() + ": " + product1.getName());
        for (OrderProduct product : order.getProducts()){
            orderProductRepository.save(product);
        }
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public OrderDto getById(Long id) {
        return mapOrderToDto(orderRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @Transactional
    @Override
    public void changeStatusToNext(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException(orderId));
        OrderStatus currentStatus = order.getStatus();
        if(currentStatus == OrderStatus.CREATED){
            order.setStatus(OrderStatus.PAID);
        }else if(currentStatus == OrderStatus.PAID) {
            order.setStatus(OrderStatus.SENT);
        }else if(currentStatus == OrderStatus.SENT) {
            order.setStatus(OrderStatus.DELIVERED);
        }else{
            return;
        }
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllByStatus(OrderStatus status) {
        return orderRepository.findAllByStatus(status).stream().map(this::mapOrderToDto).collect(Collectors.toList());
    }

    @Override
    public Order mapDtoToOrder(OrderDto dto){
        Order order = new Order();
        order.setUser(userService.mapDtoToUser(dto.getUserDto()));
        order.setProducts(
                dto.getProductsDto().stream().map(this::mapDtoToOrderProduct).collect(Collectors.toList())
        );
        order.setDelivery(deliveryService.mapDtoToDelivery(dto.getDeliveryDto()));
        order.setStatus(dto.getStatus());
        order.setId(dto.getId());
        order.setCreated(dto.getCreated());
        return order;
    }

    @Override
    public OrderProduct mapDtoToOrderProduct(OrderProductDto dto) {
        OrderProduct entity = new OrderProduct();
        if(dto.getId() != null){
            entity.setId(dto.getId());
        }
        entity.setProduct(productService.mapDtoToProduct(dto.getProductDto()));
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    @Override
    public OrderProductDto mapOrderProductToDto(OrderProduct orderProduct) {
        OrderProductDto dto = new OrderProductDto();
        dto.setId(orderProduct.getId());
        dto.setProductDto(productService.mapToDto(orderProduct.getProduct()));
        dto.setQuantity(orderProduct.getQuantity());
        return dto;
    }

    @Override
    public OrderDto mapOrderToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setCreated(order.getCreated());
        dto.setDeliveryDto(deliveryService.mapToDto(order.getDelivery()));
        dto.setId(order.getId());
        dto.setProductsDto(
                order.getProducts().stream().map(this::mapOrderProductToDto).collect(Collectors.toList())
        );
        dto.setStatus(order.getStatus());
        dto.setCreated(order.getCreated());
        dto.setUserDto(userService.mapUserToDto(order.getUser()));
        return dto;
    }
}
