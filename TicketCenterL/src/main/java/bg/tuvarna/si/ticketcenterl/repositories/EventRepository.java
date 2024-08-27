package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer eventId);

    List<Event> findByName(String name);
    List<Event> findByDistributorsId(Integer distributorId);
    List<Event> findByStatus(String status);
    List<Event> findByDate(Date date);

    List<Event> findByOrganizerId(Integer organizerId);
}
