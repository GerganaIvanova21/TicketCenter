package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Optional<Ticket> findTicketByTicketId(Integer ticketId);
    List<Ticket> findTicketByTicketType(String ticType);
    List<Ticket> findTicketByEvent_EventId(Integer eventId);

    //List<Ticket> getAllTickets();
}
