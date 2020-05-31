package pl.teo.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.entity.Delivery;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.DeliveryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DeliveryController {
    private DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @ModelAttribute("deliveryList")
    public List<Delivery> deliveryList() {
        return deliveryRepository.findAll();
    }


    @RequestMapping ("createDelivery")
    public String createDeliveryForm(Model model){
        model.addAttribute("delivery", new Delivery());
        return "delivery/createDelivery";
    }

    @RequestMapping (value = "createDelivery", method = RequestMethod.POST)
    public String createDelivery(@Valid Delivery delivery, BindingResult result, Model model){
        if(result.hasErrors()){
            return "delivery/createDelivery";
        }
        deliveryRepository.save(delivery);
        model.addAttribute("successFlag", true);
        return "delivery/createDelivery";
    }


    @RequestMapping("deleteDelivery")
    public String deleteDelivery(@RequestParam(defaultValue = "0") long id){
        deliveryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        deliveryRepository.deleteById(id);
        return "delivery/createDelivery";
    }


    @RequestMapping(value = "editDelivery")
    public String editDeliveryForm(@RequestParam(defaultValue = "0") long id, Model model){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        model.addAttribute(delivery);
        return "delivery/delivery";
    }

    @RequestMapping(value = "editDelivery", method = RequestMethod.POST)
    public String editDelivery(@Valid Delivery delivery, BindingResult result, Model model){
        if(result.hasErrors()){
            return "delivery/delivery";
        }
        deliveryRepository.save(delivery);
        model.addAttribute("successFlag", true);
        return "delivery/delivery";
    }
}
