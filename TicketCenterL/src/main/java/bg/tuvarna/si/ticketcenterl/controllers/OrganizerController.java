package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    // Create a new event
    @PostMapping("/{organizerId}/events")
    public ResponseEntity<Event> createEvent(@PathVariable Long organizerId, @RequestBody Event event) {
        Event createdEvent = organizerService.createEvent(organizerId, event);
        return ResponseEntity.ok(createdEvent);
    }

    // Update an existing event
    @PutMapping("/{organizerId}/events/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long organizerId, @PathVariable Long eventId, @RequestBody Event eventDetails) {
        Event updatedEvent = organizerService.updateEvent(organizerId, eventId, eventDetails);
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete an event
    @DeleteMapping("/{organizerId}/events/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long organizerId, @PathVariable Long eventId) {
        organizerService.deleteEvent(organizerId, eventId);
        return ResponseEntity.noContent().build();
    }

    // Get all events by organizer
    @GetMapping("/{organizerId}/events")
    public ResponseEntity<List<Event>> getAllEvents(@PathVariable Long organizerId) {
        List<Event> events = organizerService.getAllEvents(organizerId);
        return ResponseEntity.ok(events);
    }

    // Get all organizers
    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok(organizers);
    }

    // Get organizer by ID
    @GetMapping("/{organizerId}")
    public ResponseEntity<Organizer> getOrganizerByOrganizerId(@PathVariable Long organizerId) {
        Organizer organizer = organizerService.getOrganizerByOrganizerId(organizerId);
        return ResponseEntity.ok(organizer);
    }

}
