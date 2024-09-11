package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellTicketRepository extends JpaRepository<Sell_Ticket, Integer> {
    Optional<Sell_Ticket> findSellTicketBySellTicketId(Integer sellTicketId);

    List<Sell_Ticket> findSellTicketByCustomerName(String cusName);


    //Продадни билети от даден разпространител
    @Query("SELECT COUNT(s) FROM Sell_Ticket s WHERE s.distributor.id = :distributorId")
    int countTicketsSoldByDistributorId(@Param("distributorId")Integer distributorId);

    //Минимален брой продадени билети
    @Query("SELECT MIN(COUNT(s)) FROM Sell_Ticket s GROUP BY s.distributor")
    int findMinTicketsSold();

    //Максимален брой продадени билети
    @Query("SELECT MAX(COUNT(s)) FROM Sell_Ticket s GROUP BY s.distributor")
    int findMaxTicketsSold();

    //List<Sell_Ticket> getAllTickets();

    //List<Sell_Ticket> findByDistributorId(Integer distributorId);
}
