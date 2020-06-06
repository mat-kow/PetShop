package pl.teo.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.petshop.dto.DeliveryDto;
import pl.teo.petshop.service.DeliveryService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ModelAttribute("deliveryList")
    public List<DeliveryDto> deliveryList() {
        return deliveryService.getAll();
    }


    @RequestMapping ("createDelivery")
    public String getNewDeliveryForm(Model model){
        model.addAttribute("deliveryDto", new DeliveryDto());
        return "delivery/createDelivery";
    }

    @RequestMapping (value = "createDelivery", method = RequestMethod.POST)
    public String createDelivery(@Valid DeliveryDto deliveryDto, BindingResult result){
        if(result.hasErrors()){
            return "delivery/createDelivery";
        }
        deliveryService.save(deliveryDto);//todo success message
        return "redirect:createDelivery";
    }

    @RequestMapping("deleteDelivery")
    public String deleteDelivery(@RequestParam(defaultValue = "0") long id){
        deliveryService.delete(id);
        return "redirect:createDelivery";
    }

    @RequestMapping(value = "editDelivery")
    public String editDeliveryForm(@RequestParam(defaultValue = "0") long id, Model model){
        DeliveryDto deliveryDto = deliveryService.findById(id);
        model.addAttribute(deliveryDto);
        return "delivery/delivery";
    }

    @RequestMapping(value = "editDelivery", method = RequestMethod.POST)
    public String editDelivery(@Valid DeliveryDto deliveryDto, BindingResult result, Model model){
        if(result.hasErrors()){
            return "delivery/delivery";
        }
        deliveryService.save(deliveryDto);
        model.addAttribute("successFlag", true);
        return "delivery/delivery";
    }
}
