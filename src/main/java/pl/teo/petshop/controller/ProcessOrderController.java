package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.dto.OrderDto;
import pl.teo.petshop.service.OrderService;

import java.util.List;

@Controller
public class ProcessOrderController {
    private final OrderService orderService;

    @Autowired
    public ProcessOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("orders")
    private String orders(@RequestParam(required = false) OrderStatus status,
                          @RequestParam(required = false) Long changeStatusId, Model model){
        if (status != null){
            List<OrderDto> orders = orderService.getAllByStatus(status);
            model.addAttribute("orders", orders);
        }
        if (changeStatusId != null){
            orderService.changeStatusToNext(changeStatusId);
        }
        return "order/orders";
    }

    @RequestMapping("order")
    private String showOrder(@RequestParam(defaultValue = "0") Long id, Model model){
        OrderDto order = orderService.getById(id);
        model.addAttribute(order);
        return "order/order";
    }

}
