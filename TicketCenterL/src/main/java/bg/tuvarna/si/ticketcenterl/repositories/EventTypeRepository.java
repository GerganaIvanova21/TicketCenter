package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventTypeRepository extends JpaRepository<Event_Type, Long> {
    Event_Type findEventTypeById(Long eventTypeId);

    Event_Type findEventTypeByName(String eventTypeName);

    List<Event_Type> getAllEventTypes();
}
