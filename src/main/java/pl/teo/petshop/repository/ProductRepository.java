package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById (long id);
}
