package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findEventByEventId(Integer eventId);

    List<Event> findEventByName(String name);

    List<Event> findEventByDate(LocalDate date);

    List<Event> findEventByStatus(Boolean status);

    List<Event> findEventByPlace(String place);

    //търсене на събитие по организатор

    List<Event> findEventByOrganizerId(Integer organizerID);

    //търсене на събитие по тип

    //List<Event> findEventByEventType(Integer eventTypeID);

    //@Query("SELECT e FROM Event e WHERE e.eventType.eventTypeId = :eventTypeId")
    List<Event> findByEventType_EventTypeId(Integer eventTypeId);

}
