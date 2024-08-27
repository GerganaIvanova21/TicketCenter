package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import bg.tuvarna.si.ticketcenterl.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;


    public Ticket getTicketByType(String ticType) {
        return ticketRepository.findTicketByTicketType(ticType);
    }

    public Ticket getTicketByTicketId(Long ticketId) {
        return ticketRepository.findTicketByIdTicket(ticketId);
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
}
