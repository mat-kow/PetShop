package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.Product;

import javax.persistence.Id;

public interface ProductRepository extends JpaRepository<Product, Id> {
}
