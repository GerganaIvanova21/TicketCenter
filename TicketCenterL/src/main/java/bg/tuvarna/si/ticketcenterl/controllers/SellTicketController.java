package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import bg.tuvarna.si.ticketcenterl.services.SellTicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sell-tickets")
@RequiredArgsConstructor
public class SellTicketController {
    //@Autowired
    private final SellTicketServiceImpl sellTicketService;

    @PostMapping
    public ResponseEntity<Sell_Ticket> sellTicket(
            @RequestParam Integer ticketId,
            @RequestParam Integer distributorId,
            @RequestParam String customerName,
            @RequestParam Integer count){
        try {
            Sell_Ticket sellTicket = sellTicketService.sellTicket(ticketId,distributorId, customerName, count);
            return ResponseEntity.status(HttpStatus.CREATED).body(sellTicket);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public Optional<Sell_Ticket> findSellTicketById(@PathVariable Integer id){
        return sellTicketService.findSellTicketById(id);
    }

    @GetMapping
    public ResponseEntity<List<Sell_Ticket>> findAllSellTickets(){
        List<Sell_Ticket> sellTickets = sellTicketService.findAllSellTickets();
        return ResponseEntity.ok(sellTickets);
    }

    @GetMapping("/sell-customer")
    public ResponseEntity<List<Sell_Ticket>> findSellTicketByCustomerName(@RequestParam String cusName){
        List<Sell_Ticket> sellTickets = sellTicketService.findSellTicketByCustomerName(cusName);
        return ResponseEntity.ok(sellTickets);
    }

    @DeleteMapping("/{id}")
    public void deleteSellTicket(@PathVariable Integer id){
        sellTicketService.deleteSellTicket(id);
    }


    /*

    @Autowired
    private SellTicketService sellTicketService;

    // Sell a ticket
    @PostMapping("/{ticketId}/sell")
    public ResponseEntity<Sell_Ticket> sellTicket(
            @PathVariable Long ticketId, @RequestParam String customerInfo, @RequestParam Integer count) {
        Sell_Ticket sellTicket = sellTicketService.sellTicket(ticketId, customerInfo, count);
        return ResponseEntity.ok(sellTicket);
    }

    // Check ticket availability for an event
    @GetMapping("/{eventId}/availability")
    public ResponseEntity<Boolean> checkTicketAvailability(@PathVariable Long eventId) {
        boolean isAvailable = sellTicketService.checkTicketAvailability(eventId);
        return ResponseEntity.ok(isAvailable);
    }

    // Get available ticket count for an event
    @GetMapping("/{eventId}/available-count")
    public ResponseEntity<Long> getAvailableTicketCount(@PathVariable Long eventId) {
        long availableCount = sellTicketService.getAvailableTicketCount(eventId);
        return ResponseEntity.ok(availableCount);
    }*/
}
