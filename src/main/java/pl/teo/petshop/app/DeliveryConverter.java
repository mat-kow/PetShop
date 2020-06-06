package pl.teo.petshop.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.teo.petshop.dto.DeliveryDto;
import pl.teo.petshop.service.DeliveryService;

@Component
public class DeliveryConverter implements Converter<String, DeliveryDto> {
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryConverter(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Override
    public DeliveryDto convert(String s) {
        return deliveryService.findByName(s);
    }
}
