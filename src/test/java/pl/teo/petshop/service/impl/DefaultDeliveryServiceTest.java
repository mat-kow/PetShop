package pl.teo.petshop.service.impl;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.teo.petshop.dto.DeliveryDto;
import pl.teo.petshop.entity.Delivery;
import pl.teo.petshop.repository.DeliveryRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultDeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DefaultDeliveryService deliveryService;


    @Test
    void should_get_list_of_dtos() {
        when(deliveryRepository.findAll()).thenReturn(mockGetAll());
        MatcherAssert.assertThat(deliveryService.getAll(), Matchers.hasSize(2));
        assertEquals(deliveryService.getAll().get(0).getClass(), DeliveryDto.class);
    }

    @Test
    void should_map_delivery_to_dto() {
        DeliveryDto dto = getDto();
        Delivery entity = getDelivery();
        assertTrue(dto.equals(deliveryService.mapToDto(entity)));
        dto.setName("shop");
        assertFalse(dto.equals(deliveryService.mapToDto(entity)));
    }

    @Test
    void should_map_dto_to_delivery() {
        DeliveryDto dto = getDto();
        Delivery entity = getDelivery();
        assertTrue(entity.equals(deliveryService.mapDtoToDelivery(dto)));
    }

    private List<Delivery> mockGetAll() {
        Delivery delivery1 = new Delivery();
        delivery1.setName("shop");
        Delivery delivery2 = new Delivery();
        delivery2.setName("courier");
        return Arrays.asList(delivery1, delivery2);
    }

    private Delivery getDelivery(){
        Delivery delivery = new Delivery();
        delivery.setId(123L);
        delivery.setName("courier");
        delivery.setLabel("Kurier");
        delivery.setCost(BigDecimal.valueOf(456.23));
        return delivery;
    }

    private DeliveryDto getDto(){
        DeliveryDto dto = new DeliveryDto();
        dto.setId(123L);
        dto.setName("courier");
        dto.setLabel("Kurier");
        dto.setCost(BigDecimal.valueOf(456.23));
    return dto;
    }
}