package pl.teo.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.entity.Order;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.OrderRepository;

@Service
public class ChangeOrderStatusService {

    private OrderRepository orderRepository;

    @Autowired
    public ChangeOrderStatusService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void change(Long orderId){
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
}
