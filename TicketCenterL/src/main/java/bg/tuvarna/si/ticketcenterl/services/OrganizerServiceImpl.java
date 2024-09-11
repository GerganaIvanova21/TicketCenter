package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.EventRepository;
import bg.tuvarna.si.ticketcenterl.repositories.EventTypeRepository;
import bg.tuvarna.si.ticketcenterl.repositories.OrganizerRepository;
import bg.tuvarna.si.ticketcenterl.services.interfaces.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class OrganizerServiceImpl implements OrganizerService {
    private final DistributorRepository distributorRepository;
    private final OrganizerRepository organizerRepository;
    private final EventTypeRepository eventTypeRepository;

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(String name, String description, LocalDate date, LocalTime time, String place, Integer eventTypeId,
                             Boolean status, Integer organizerId, Set<Integer> distributorIds){
        Organizer organizer = organizerRepository.findOrganizerById(organizerId)
                .orElseThrow(() -> new IllegalArgumentException("Organizer not found"));

        Set<Distributor> distributors = new HashSet<>();
        for (Integer distributorId : distributorIds){
            Distributor distributor = distributorRepository.findDistributorById(distributorId)
                    .orElseThrow(() -> new IllegalArgumentException("Distributor not found"));
            distributors.add(distributor);
        }

        Event_Type eventType = eventTypeRepository.findEventTypeByEventTypeId(eventTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Event type not found"));

        Event event =  Event.builder()
                .name(name)
                .description(description)
                .date(date)
                .time(time)
                .place(place)
                .status(status)
                .organizer(organizer)
                .distribEvent(distributors)
                .eventType(eventType)
                .build();
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Integer eventID, String name, String description, LocalDate date, LocalTime time, String place,
                             Boolean status, Set<Integer> distributorIds, Integer eventTypeId){
        Event event = eventRepository.findEventByEventId(eventID)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Set<Distributor> distributors = new HashSet<>();
        for(Integer distributorId: distributorIds){
            Distributor distributor = distributorRepository.findDistributorById(distributorId)
                    .orElseThrow(() -> new IllegalArgumentException("Distributor not found"));
            distributors.add(distributor);
        }

        if(eventTypeId != null){
            Event_Type eventType = eventTypeRepository.findEventTypeByEventTypeId(eventTypeId)
                    .orElseThrow(() -> new IllegalArgumentException("Event type not found"));
            event.setEventType(eventType);
        }

        event.setName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setTime(time);
        event.setPlace(place);
        event.setStatus(status);
        event.setDistribEvent(distributors);

        return eventRepository.save(event);
    }

    public void deleteEvent(Integer id){
        eventRepository.deleteById(id);
    }

    /*@Override
    public Event assignDistributorsToEvent(Integer eventID, List<Distributor> distributors){
        Event event = eventRepository.findEventById(eventID)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        for(Distributor distributor: distributors){
            event.getDistribEvent().add(distributor);
        }
        return eventRepository.save(event);
    }*/


    public List<Organizer> findAllOrganizers(){
        return organizerRepository.findAll();
    }

    public Optional<Organizer> findOrganizerById(Integer id){
        return organizerRepository.findOrganizerById(id);
    }

    public List<Organizer> findOrganizerByName(String firstName, String lastName){
        return organizerRepository.findOrganizerByFirstNameAndLastName(firstName,lastName);
    }
}
