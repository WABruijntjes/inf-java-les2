package nl.inholland.infjavales2.repository;

import nl.inholland.infjavales2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
