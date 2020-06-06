package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.teo.petshop.dto.*;
import pl.teo.petshop.service.DeliveryService;
import pl.teo.petshop.service.OrderService;
import pl.teo.petshop.service.ProductService;
import pl.teo.petshop.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"cart", "orderDto"})
public class OrderController {
    private final OrderService orderService;
    private final DeliveryService deliveryService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService, DeliveryService deliveryService,
                           ProductService productService) {
        this.orderService = orderService;
        this.deliveryService = deliveryService;
        this.userService = userService;
        this.productService = productService;
    }

    @ModelAttribute("deliveryOptions")
    public List<DeliveryDto> deliveryOptions() {//todo dto?
        return deliveryService.getAll();
    }

    @ModelAttribute("cart")
    public List<OrderProductDto> getCart(HttpSession session) {
        List<OrderProductDto> cart = (List<OrderProductDto>) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<>();
        }
        return cart;
    }

    @RequestMapping(value = "addToCart", method = RequestMethod.POST)
    public String addToCart(@RequestParam int quantity, @RequestParam long productId, HttpSession session, Model model){
        List<OrderProductDto> cart = getCart(session);
        ProductDto productDto = productService.getById(productId);
        cart.add(new OrderProductDto(productDto, quantity));
        model.addAttribute("cart", cart);

        return "redirect:product?id=" + productId;
    }

    @RequestMapping("cart")
    public String showCart(@RequestParam(required = false) Integer deleteIndex, HttpSession session){
        List<OrderProductDto> cart = getCart(session);
        if (deleteIndex != null && cart != null){
            if(deleteIndex < cart.size()) {
                cart.remove(deleteIndex.intValue());
            }
        }
        return "order/cart";
    }

    @RequestMapping("chooseDelivery")
    public String chooseDelivery(Model model, HttpSession session){
        List<OrderProductDto> cart = getCart(session);
        if(cart.isEmpty()){
            return "redirect:home";
        }
        UserDto userDto = userService.getCurrentUserDto();
        UserDetailsDto userDetailsDto = userService.getUserDetailsDto(userDto);
        model.addAttribute(userDetailsDto);
        OrderDto orderDto = new OrderDto(userDto, cart);
        model.addAttribute("orderDto", orderDto);
        return "order/chooseDelivery";
    }
    @RequestMapping(value = "summary", method = RequestMethod.POST)
    public String summary(@RequestParam(required = false) DeliveryDto delivery, HttpSession session, Model model){
        if(delivery == null){
            model.addAttribute("deliveryError",true);
            return "redirect:chooseDelivery";
        }
        OrderDto orderDto = (OrderDto) session.getAttribute("orderDto");
        orderDto.setDeliveryDto(delivery);
        return "order/summary";
    }

    @RequestMapping("confirmOrder")
    public String confirmOrder(HttpSession session, Model model){
        OrderDto orderDto = (OrderDto) session.getAttribute("orderDto");
        if(orderDto == null){
            return "redirect:home";
        }
        long orderId = orderService.save(orderDto);
        model.addAttribute("orderId", orderId);
        return "order/successOrder";
    }

}
