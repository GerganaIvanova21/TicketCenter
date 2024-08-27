package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SellTicketRepository extends JpaRepository<Sell_Ticket, Integer> {
    Sell_Ticket findSell_TicketById(Integer sellTicketId);

    //List<Sell_Ticket> getAllTickets();

    List<Sell_Ticket> findByDistributorId(Integer distributorId);
}
