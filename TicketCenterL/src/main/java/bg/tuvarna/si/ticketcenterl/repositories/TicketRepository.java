package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findTicketByIdTicket(Integer ticketId);
    List<Ticket> findTicketByTicketType(String ticType);
    List<Ticket> findByEventId(Integer eventId);

    //List<Ticket> getAllTickets();
}
