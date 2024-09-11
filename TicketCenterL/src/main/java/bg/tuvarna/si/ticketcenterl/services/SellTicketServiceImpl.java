package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.EventRepository;
import bg.tuvarna.si.ticketcenterl.repositories.SellTicketRepository;
import bg.tuvarna.si.ticketcenterl.repositories.TicketRepository;
import bg.tuvarna.si.ticketcenterl.services.interfaces.SellTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class SellTicketServiceImpl implements SellTicketService {
    private final SellTicketRepository sellTicketRepository;
    private final TicketRepository ticketRepository;
    private final DistributorRepository distributorRepository;
    private final EventRepository eventRepository;

    public Sell_Ticket sellTicket(Integer ticketId, Integer distributorId, String customerName, Integer count){
        Ticket ticket = ticketRepository.findTicketByTicketId(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        Distributor distributor = distributorRepository.findDistributorById(distributorId)
                .orElseThrow(()-> new IllegalArgumentException("Distributor not found"));

        if(ticket.getFree_seats() < count){
            throw new IllegalArgumentException("Not enough available seats");
        }

        ticket.setOccupied_seats(ticket.getOccupied_seats() + count);
        ticket.setFree_seats(ticket.getFree_seats() - count);
        ticketRepository.save(ticket);

        Sell_Ticket sellTicket = Sell_Ticket.builder()
                .tickets(ticket)
                .distributor(distributor)
                .customerName(customerName)
                .count(count)
                .build();

        return sellTicketRepository.save(sellTicket);
    }

    public int countSoldTicketsByDistributor(Integer distributorId){
        return sellTicketRepository.countTicketsSoldByDistributorId(distributorId);
    }

    public int findMinSoldTickets(){
        return sellTicketRepository.findMinTicketsSold();
    }

    public int findMaxSoldTickets(){
        return sellTicketRepository.findMaxTicketsSold();
    }


    public Optional<Sell_Ticket> findSellTicketById(Integer id){
        return sellTicketRepository.findSellTicketBySellTicketId(id);
    }

    public List<Sell_Ticket> findAllSellTickets(){
        return sellTicketRepository.findAll();
    }

    public List<Sell_Ticket> findSellTicketByCustomerName(String cusName){
        return sellTicketRepository.findSellTicketByCustomerName(cusName);
    }

    public void deleteSellTicket(Integer id){
        sellTicketRepository.deleteById(id);
    }

    /*
    @Autowired
    private TicketRepository ticketRepository;

    public Sell_Ticket sellTicket(Long ticketId, String customerInfo, Integer count) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            int freeSeats = ticket.getFree_seats();
            if (freeSeats >= count) {
                ticket.setFree_seats(freeSeats - count);
                ticket.setOccupied_seats(ticket.getOccupied_seats() + count);
                ticketRepository.save(ticket);

                Sell_Ticket sellTicket = new Sell_Ticket();
                sellTicket.setTickets(ticket);
                sellTicket.setCustomerName(customerInfo);
                sellTicket.setCount(count);
                // Set the distributor here if needed
                return sellTicketRepository.save(sellTicket);
            } else {
                throw new RuntimeException("Not enough tickets available");
            }
        } else {
            throw new RuntimeException("Ticket not found");
        }
    }

    public boolean checkTicketAvailability(Long eventId) {
        List<Ticket> tickets = ticketRepository.findByEventId(eventId);
        for (Ticket ticket : tickets) {
            if (ticket.getFree_seats() > 0) {
                return true;
            }
        }
        return false;
    }

    public long getAvailableTicketCount(Long eventId) {
        long availableCount = 0;
        List<Ticket> tickets = ticketRepository.findByEventId(eventId);
        for (Ticket ticket : tickets) {
            availableCount += ticket.getFree_seats();
        }
        return availableCount;
    }

*/



}
