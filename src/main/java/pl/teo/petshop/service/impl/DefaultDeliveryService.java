package pl.teo.petshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.teo.petshop.dto.DeliveryDto;
import pl.teo.petshop.entity.Delivery;
import pl.teo.petshop.exception.ResourceNotFoundException;
import pl.teo.petshop.repository.DeliveryRepository;
import pl.teo.petshop.service.DeliveryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultDeliveryService implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DefaultDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    @Override
    public void save(DeliveryDto deliveryDto) {
        deliveryRepository.save(mapDtoToDelivery(deliveryDto));
    }

    @Override
    public List<DeliveryDto> getAll() {
        return deliveryRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (deliveryRepository.existsById(id)){
            deliveryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }

    }

    @Override
    public DeliveryDto findById(long id) {
        return mapToDto(deliveryRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public DeliveryDto findByName(String name) {
        return mapToDto(deliveryRepository.findByName(name));
    }

    @Override
    public DeliveryDto mapToDto(Delivery delivery){
        DeliveryDto dto = new DeliveryDto();
        dto.setCost(delivery.getCost());
        dto.setLabel(delivery.getLabel());
        dto.setName(delivery.getName());
        dto.setId(delivery.getId());
        return dto;
    }

    @Override
    public Delivery mapDtoToDelivery(DeliveryDto deliveryDto){
        Delivery delivery = new Delivery();
        if(deliveryDto.getId() != null){
            delivery.setId(deliveryDto.getId());
        }
        delivery.setLabel(deliveryDto.getLabel());
        delivery.setCost(deliveryDto.getCost());
        delivery.setName(deliveryDto.getName());
        return delivery;
    }
}
