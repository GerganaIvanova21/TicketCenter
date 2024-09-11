package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Optional<Organizer> findOrganizerById(Integer id);

    List<Organizer> findOrganizerByFirstNameAndLastName(String firstName, String lastName);


}
