package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer eventId);

    List<Event> findEventByName(String name);

    List<Event> findEventByDate(LocalDate date);

    List<Event> findEventByStatus(Boolean status);

    List<Event> findEventByPlace(String place);

    //търсене на събитие по организатор

    List<Event> findEventByOrganizerId(Integer organizerID);

    //търсене на събитие по тип
    List<Event> findEventByEventTypeID(Integer eventTypeID);

}
