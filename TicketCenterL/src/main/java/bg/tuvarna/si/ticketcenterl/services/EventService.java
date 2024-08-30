package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class EventService {
    @Autowired
    private final EventRepository eventRepository;

    private Event findEventById(Integer id){
        return eventRepository.findEventById(id);
    }

    private List<Event> findEventByName(String name){
        return eventRepository.findEventByName(name);
    }
    private List<Event> findEventByDate(LocalDate date){
        return eventRepository.findEventByDate(date);
    }

    private List<Event> findEventByPlace(String place){
        return eventRepository.findEventByPlace(place);
    }

    private List<Event> findEventByStatus(Boolean status){
        return eventRepository.findEventByStatus(status);
    }
    private List<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    /*
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private DistributorRepository distributorRepository;

    @Autowired
    private NotificationService notificationService;

    public Event addEvent(Long organizerId, Event event) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(organizerId);
        if (optionalOrganizer.isPresent()) {
            event.setOrganizer(optionalOrganizer.get());
            Event savedEvent = eventRepository.save(event);
            notifyDistributorsAboutNewEvent(savedEvent);
            return savedEvent;
        } else {
            throw new RuntimeException("Organizer not found");
        }
    }

    public Ticket addTicket(Long eventId, Ticket ticket) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            ticket.setEvent(optionalEvent.get());
            return ticketRepository.save(ticket);
        } else {
            throw new RuntimeException("Event not found");
        }
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public List<Event> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public List<Event> getEventsByDistributor(Long distributorId) {
        return eventRepository.findByDistributorsId(distributorId);
    }

    public List<Event> getEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    public List<Event> getEventsByDate(Date date) {
        return eventRepository.findByDate(date);
    }

    public void notifyDistributorsAboutNewEvent(Event event) {
        List<Distributor> distributors = distributorRepository.findAll();
        for (Distributor distributor : distributors) {
            Notification notification = new Notification();
            notification.setDistributor(distributor);
            notification.setEvent(event);
            notification.setMessage("New event added: " + event.getName());
            notificationService.sendNotification(notification);
        }
    }

    public void notifyDistributorsAboutUpcomingEvent(Event event) {
        List<Distributor> distributors = distributorRepository.findByEventId(event.getIdEvent());
        for (Distributor distributor : distributors) {
            Notification notification = new Notification();
            notification.setDistributor(distributor);
            notification.setEvent(event);
            notification.setMessage("Upcoming event: " + event.getName());
            notificationService.sendNotification(notification);
        }
    }

    /*public void notifyDistributorsAboutUnsoldTickets(Event event) {
        List<Distributor> distributors = distributorRepository.findByEventId(event.getIdEvent());
        for (Distributor distributor : distributors) {
            Notification notification = new Notification();
            notification.setDistributor(distributor);
            notification.setEvent(event);
            notification.setMessage("Event with unsold tickets: " + event.getName());
            notificationService.sendNotification(notification);
        }
    }*/
}
