package pl.teo.petshop.service;

import pl.teo.petshop.dto.DeliveryDto;
import pl.teo.petshop.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDto> getAll();
    void save(DeliveryDto deliveryDto);
    void delete(Long id);
    DeliveryDto findById(long id);
    Delivery mapDtoToDelivery(DeliveryDto deliveryDto);
    DeliveryDto mapToDto(Delivery delivery);
    DeliveryDto findByName (String name);
}
