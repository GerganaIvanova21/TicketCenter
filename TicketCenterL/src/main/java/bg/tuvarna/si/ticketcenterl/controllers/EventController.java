package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    //@Autowired
    private final EventService eventService;

    @GetMapping("{id}")
    public Optional<Event> findEventById(@PathVariable Integer id){
        return eventService.findEventById(id);
    }

    @GetMapping("{name}")
    public List<Event> findEventByName(@PathVariable String name){
        return eventService.findEventByName(name);
    }

    @GetMapping("{date}")
    public List<Event> findEventByDate(@PathVariable LocalDate date){
        return eventService.findEventByDate(date);
    }

    @GetMapping("{place}")
    public List<Event> findEventByPlace(@PathVariable String place){
        return eventService.findEventByPlace(place);
    }

    @GetMapping("{status}")
    public List<Event> findEventByStatus(@PathVariable Boolean status){
        return eventService.findEventByStatus(status);
    }

    @GetMapping
    public List<Event> findAllEvents(){
        return eventService.findAllEvents();
    }

    @GetMapping("{organizerId}")
    public ResponseEntity <List<Event>> findEventByOrganizerId(@PathVariable Integer organizerId){
        List<Event> events = eventService.findEventByOrganizerId(organizerId);
        if(events.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(events);
    }


    @GetMapping("/{eventTypeId}")
    public ResponseEntity<List<Event>> findEventByEventTypeID(@PathVariable Integer eventTypeId) {
        List<Event> events = eventService.findEventByEventTypeID(eventTypeId);
        if (events.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(events);
    }


}
