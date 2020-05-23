package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teo.petshop.entity.User;

import javax.persistence.Id;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserNameIgnoreCase(String userName);
    Optional<User> findByEmailIgnoreCase(String userName);
    Optional<User> findById(long id);
}
