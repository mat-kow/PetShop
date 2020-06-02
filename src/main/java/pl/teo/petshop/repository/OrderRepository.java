package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.OrderStatus;
import pl.teo.petshop.entity.Order;

import java.util.ArrayList;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    ArrayList<Order> findAllByStatus(OrderStatus status);
    Optional<Order> findById(Long id);
}
