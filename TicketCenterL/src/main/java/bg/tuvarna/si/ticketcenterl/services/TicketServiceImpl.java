package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import bg.tuvarna.si.ticketcenterl.repositories.TicketRepository;
import bg.tuvarna.si.ticketcenterl.services.interfaces.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public Ticket createTicket(String ticketType, Double price, Integer freeSeats, Integer occupiedSeats, Event event){
        Ticket ticket = Ticket.builder()
                .ticketType(ticketType)
                .price(price)
                .free_seats(freeSeats)
                .occupied_seats(occupiedSeats)
                .event(event)
                .build();
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Integer ticketId, String ticketType, Double price, Integer freeSeats, Integer occupiedSeats){
       Ticket ticket = ticketRepository.findTicketByTicketId(ticketId)
               .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

       ticket.setTicketType(ticketType);
       ticket.setPrice(price);
       ticket.setFree_seats(freeSeats);
       ticket.setOccupied_seats(occupiedSeats);

       return ticketRepository.save(ticket);
    }

    public Optional<Ticket> findTicketById(Integer id){
        return ticketRepository.findTicketByTicketId(id);
    }

    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }

    public List<Ticket> findTicketByTicketType(String ticketType){
        return ticketRepository.findTicketByTicketType(ticketType);
    }

    public List<Ticket> findTicketByEventId(Integer eventId){
        return ticketRepository.findTicketByEvent_EventId(eventId);
    }

    public void deleteTicket(Integer id){
        ticketRepository.deleteById(id);
    }

}
