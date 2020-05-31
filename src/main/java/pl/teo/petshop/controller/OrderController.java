package pl.teo.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.teo.petshop.entity.*;
import pl.teo.petshop.exception.ProductNotFoundException;
import pl.teo.petshop.exception.UserNotFoundException;
import pl.teo.petshop.repository.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"cart", "order"})
public class OrderController {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private OrderProductRepository orderProductRepository;
    private DeliveryRepository deliveryRepository;

    @Autowired
    public OrderController(ProductRepository productRepository, UserRepository userRepository, OrderRepository orderRepository,
                           OrderProductRepository orderProductRepository, DeliveryRepository deliveryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @ModelAttribute("deliveryOptions")
    public List<Delivery> deliveryOptions() {
        return deliveryRepository.findAll();
    }

    @RequestMapping(value = "addToCart", method = RequestMethod.POST)
    public String addToCart(@RequestParam int quantity, @RequestParam long productId, HttpSession session, Model model){
        List<OrderProduct> cart = (List<OrderProduct>) session.getAttribute("cart");
        if(cart == null){
            cart = new ArrayList<OrderProduct>();
        }
        Product product= productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        cart.add(new OrderProduct(product, quantity));
        model.addAttribute("cart", cart);

        return "redirect:product?id=" + productId;
    }

    @RequestMapping("cart")
    public String showCart(@RequestParam Optional<Integer> deleteIndex, HttpSession session, Model model){
        List<OrderProduct> cart = (List<OrderProduct>) session.getAttribute("cart");
        if (deleteIndex.isPresent() && cart != null){
            int index = deleteIndex.get();
            if(index < cart.size()) {
                cart.remove(index);
            }
        }
        return "order/cart";
    }

    @RequestMapping("chooseDelivery")
    public String chooseDelivery(Model model, Principal principal, HttpSession session){
        List<OrderProduct> cart = (List<OrderProduct>) session.getAttribute("cart");
        //todo if cart is null or empty
        Optional<User> user = userRepository.findByUserNameIgnoreCase(principal.getName());
        UserDetails userDetails = user.orElseThrow(UserNotFoundException::new).getUserDetails();
        model.addAttribute(userDetails);
        Order order = new Order(user.get(), cart);
        model.addAttribute(order);
        return "order/chooseDelivery";
    }
    @RequestMapping(value = "summary", method = RequestMethod.POST)
    public String summary(@RequestParam Delivery delivery, HttpSession session){
        Order order = (Order) session.getAttribute("order");
        order.setDelivery(delivery);
        return "order/summary";
    }

    @RequestMapping("confirmOrder")
    public String confirmOrder(HttpSession session, Model model){
        Order order = (Order) session.getAttribute("order");
        for (OrderProduct product : order.getProducts()){
            orderProductRepository.save(product);
        }
        orderRepository.save(order);
        model.addAttribute("orderId", order.getId());
        return "order/successOrder";
    }

}
