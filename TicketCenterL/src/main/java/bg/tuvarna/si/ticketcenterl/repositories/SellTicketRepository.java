package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SellTicketRepository extends JpaRepository<Sell_Ticket, Long> {
    Sell_Ticket findSell_TicketById(Long sellTicketId);

    List<Sell_Ticket> getAllTickets();
}
