package bg.tuvarna.si.ticketcenterl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import bg.tuvarna.si.ticketcenterl.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
