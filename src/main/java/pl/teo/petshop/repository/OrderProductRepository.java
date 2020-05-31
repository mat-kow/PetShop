package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {
}
