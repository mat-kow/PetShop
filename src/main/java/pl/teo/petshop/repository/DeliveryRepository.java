package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByName(String name);
}
