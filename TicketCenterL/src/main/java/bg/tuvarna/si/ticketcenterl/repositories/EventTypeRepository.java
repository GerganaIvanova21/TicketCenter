package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventTypeRepository extends JpaRepository<Event_Type, Integer> {
    Optional<Event_Type> findEventTypeByEventTypeId(Integer eventTypeId);

    List<Event_Type> findEventTypeByEventTypeName(String eventTypeName);


}
