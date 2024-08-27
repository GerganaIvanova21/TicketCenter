package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import bg.tuvarna.si.ticketcenterl.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-types")
public class EventTypeController {
    @Autowired
    private EventTypeService eventTypeService;

    // Create a new event type
    @PostMapping
    public Event_Type createEventType(@RequestBody Event_Type eventType) {
        return eventTypeService.createEventType(eventType);
    }

    // Delete an event type by ID
    @DeleteMapping("/{id}")
    public void deleteEventType(@PathVariable Long id) {
        eventTypeService.deleteEventType(id);
    }

    // Get all event types
    @GetMapping
    public List<Event_Type> getAllEventTypes() {
       return eventTypeService.getAllEventTypes();
    }

    // Get event type by ID
    @GetMapping("/{id}")
    public Event_Type getEventTypeById(@PathVariable Long id) {
        return eventTypeService.getEventTypeById(id);
    }

    // Get event type by name
    @GetMapping("/name/{name}")
    public Event_Type getEventTypeByName(@PathVariable String name) {
       return eventTypeService.getEventTypeByName(name);
    }

}
