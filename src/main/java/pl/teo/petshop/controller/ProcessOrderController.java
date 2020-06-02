package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.entity.Order;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.OrderRepository;
import pl.teo.petshop.service.ChangeOrderStatusService;

import java.util.List;

@Controller
public class ProcessOrderController {
    OrderRepository orderRepository;
    ChangeOrderStatusService changeOrderStatusService;

    @Autowired
    public ProcessOrderController(OrderRepository orderRepository, ChangeOrderStatusService changeOrderStatusService) {
        this.orderRepository = orderRepository;
        this.changeOrderStatusService = changeOrderStatusService;
    }

    @RequestMapping("orders")
    private String orders(@RequestParam(required = false) OrderStatus status, @RequestParam(required = false) Long changeStatusId,
                          Model model){
        if (status != null){
            List<Order> orders = orderRepository.findAllByStatus(status);
            model.addAttribute("orders", orders);
        }
        if (changeStatusId != null){
            changeOrderStatusService.change(changeStatusId);
        }
        return "order/orders";
    }

    @RequestMapping("order")
    private String showOrder(@RequestParam(defaultValue = "0") Long id, Model model){
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        model.addAttribute(order);
        return "order/order";
    }

}
