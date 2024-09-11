package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.models.request.EventRequest;
import bg.tuvarna.si.ticketcenterl.services.OrganizerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organizers")
public class OrganizerController {

    private final OrganizerServiceImpl organizerService;

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest eventRequest){
        Event event = organizerService.createEvent(
                eventRequest.getName(),
                eventRequest.getDescription(),
                eventRequest.getDate(),
                eventRequest.getTime(),
                eventRequest.getPlace(),
                eventRequest.getEventTypeId(),
                eventRequest.getStatus(),
                eventRequest.getOrganizerId(),
                eventRequest.getDistributorIds());
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody EventRequest eventRequest){
        Event event = organizerService.updateEvent(
                id,
                eventRequest.getName(),
                eventRequest.getDescription(),
                eventRequest.getDate(),
                eventRequest.getTime(),
                eventRequest.getPlace(),
                eventRequest.getStatus(),
                eventRequest.getDistributorIds(),
                eventRequest.getEventTypeId()
        );
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Integer id){
        organizerService.deleteEvent(id);
    }

    @GetMapping
    public List<Organizer> findAllOrganizers(){
        return organizerService.findAllOrganizers();
    }

    @GetMapping("{id}")
    public Optional<Organizer> findOrganizerById(@PathVariable Integer id){
        return organizerService.findOrganizerById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Organizer>> findOrganizerByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName){
        List<Organizer> organizers = organizerService.findOrganizerByName(firstName, lastName);
        if(organizers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(organizers);
    }

}
