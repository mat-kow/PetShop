package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
