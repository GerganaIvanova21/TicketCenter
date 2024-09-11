package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Ticket;
import bg.tuvarna.si.ticketcenterl.services.TicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    //@Autowired
    private final TicketServiceImpl ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticketReq){
        Ticket ticket = ticketService.createTicket(
                ticketReq.getEventType(),
                ticketReq.getPrice(),
                ticketReq.getFree_seats(),
                ticketReq.getOccupied_seats(),
                ticketReq.getEvent()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @PutMapping("{ticketId}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Integer ticketId, @RequestBody Ticket ticketReq){
        Ticket updatedTicket = ticketService.updateTicket(
                ticketId,
                ticketReq.getEventType(),
                ticketReq.getPrice(),
                ticketReq.getFree_seats(),
                ticketReq.getOccupied_seats()
        );
        return ResponseEntity.ok(updatedTicket);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Integer id){
        Optional<Ticket> ticket =ticketService.findTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping
    public ResponseEntity<List<Ticket>> findAllTickets(){
        List<Ticket> tickets = ticketService.findAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("{ticketType}")
    public ResponseEntity <List<Ticket>> findTicketByTicketType(@PathVariable String ticketType){
        List<Ticket> tickets = ticketService.findTicketByTicketType(ticketType);
        if(tickets.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("{eventId}")
    public ResponseEntity<List<Ticket>> findTicketByEventId(@PathVariable Integer eventId){
        List<Ticket> tickets = ticketService.findTicketByEventId(eventId);
        if(tickets.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tickets);
    }

    @DeleteMapping("{id}")
    public void deleteTicket(@PathVariable Integer id){
        ticketService.deleteTicket(id);
    }


    /*
    @Autowired
    private TicketService ticketService;

    // Get ticket by ticket ID
    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long ticketId) {
        Ticket ticket = ticketService.getTicketByTicketId(ticketId);
        return ResponseEntity.ok(ticket);
    }

    // Get ticket by ticket type
    @GetMapping("/type/{ticType}")
    public ResponseEntity<Ticket> getTicketByType(@PathVariable String ticType) {
        Ticket ticket = ticketService.getTicketByType(ticType);
        return ResponseEntity.ok(ticket);
    }

    // Get all tickets
    @GetMapping("")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
*/
}
