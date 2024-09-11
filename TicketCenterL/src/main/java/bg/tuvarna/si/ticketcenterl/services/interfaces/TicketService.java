package bg.tuvarna.si.ticketcenterl.services.interfaces;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Ticket;

public interface TicketService {
     Ticket createTicket(String ticketType, Double price, Integer freeSeats, Integer occupiedSeats, Event event);
     Ticket updateTicket(Integer ticketId, String ticketType, Double price, Integer freeSeats, Integer occupiedSeats);
}
