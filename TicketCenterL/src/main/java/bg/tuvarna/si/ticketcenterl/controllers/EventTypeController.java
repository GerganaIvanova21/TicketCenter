package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import bg.tuvarna.si.ticketcenterl.services.EventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventTypes")
@RequiredArgsConstructor
public class EventTypeController {

    //@Autowired
    private final EventTypeService eventTypeService;

    // Create a new event type
    @PostMapping("create-type")
    public Event_Type createEventType(@RequestBody Event_Type eventType) {
        return eventTypeService.creteEventType(eventType);
    }

    // Delete an event type by ID
    @DeleteMapping("/{id}")
    public void deleteEventType(@PathVariable Integer id) {
        eventTypeService.deleteEventType(id);
    }

    // Get all event types
    @GetMapping
    public List<Event_Type> findAllEventTypes() {
       return eventTypeService.findAllEventTypes();
    }

    // Get event type by name
    @GetMapping("/{name}")
    public  List<Event_Type> findEventTypeByName(@PathVariable String name){
        return eventTypeService.findEventTypeByName(name);
    }

    // Get event type by ID
    @GetMapping("{id}")
    public Optional<Event_Type> findEventTypeById(@PathVariable Integer id){
        return eventTypeService.findEventTypeById(id);
    }

}
