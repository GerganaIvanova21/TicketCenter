package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.repositories.EventRepository;
import bg.tuvarna.si.ticketcenterl.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class OrganizerService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;


    public Event createEvent(Long organizerId, Event event) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(organizerId);
        if (optionalOrganizer.isPresent()) {
            event.setOrganizer(optionalOrganizer.get());
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("Organizer not found");
        }
    }

    public Event updateEvent(Long organizerId, Long eventId, Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent() && optionalEvent.get().getOrganizer().getIdUser() == organizerId) {
            Event event = optionalEvent.get();
            event.setName(eventDetails.getName());
            event.setDescription(eventDetails.getDescription());
            event.setDate(eventDetails.getDate());
            event.setTime(eventDetails.getTime());
            event.setPlace(eventDetails.getPlace());
            event.setStatus(eventDetails.getStatus());
            return eventRepository.save(event);
        } else {
            throw new RuntimeException("Event not found or you are not the organizer of this event");
        }
    }

    public void deleteEvent(Long organizerId, Long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent() && optionalEvent.get().getOrganizer().getIdUser() == organizerId) {
            eventRepository.deleteById(eventId);
        } else {
            throw new RuntimeException("Event not found or you are not the organizer of this event");
        }
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.getAllOrganizers();
    }

    public Organizer getOrganizerByOrganizerId(Long organizerID) {
        return organizerRepository.findOrganizerById(organizerID);
    }

    public List<Event> getAllEvents(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }
}
