package pl.teo.petshop.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.teo.petshop.entity.Delivery;
import pl.teo.petshop.repository.DeliveryRepository;

@Component
public class DeliveryConverter implements Converter<String, Delivery> {
    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryConverter(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery convert(String s) {
        return deliveryRepository.findByName(s);
    }
}
