package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
