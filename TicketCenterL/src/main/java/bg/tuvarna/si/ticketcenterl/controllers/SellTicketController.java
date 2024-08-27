package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import bg.tuvarna.si.ticketcenterl.services.SellTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sell-tickets")
public class SellTicketController {

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
    }
}
