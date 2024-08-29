package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Organizer findOrganizerById(Integer organizerId);

    List<Organizer> findOrganizerByName(String firstName, String lastName);


}
