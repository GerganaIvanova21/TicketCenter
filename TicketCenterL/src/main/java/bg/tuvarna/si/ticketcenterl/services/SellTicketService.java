package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import bg.tuvarna.si.ticketcenterl.repositories.SellTicketRepository;
import bg.tuvarna.si.ticketcenterl.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class SellTicketService {
    @Autowired
    private SellTicketRepository sellTicketRepository;

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





}
