package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Event_Type;
import bg.tuvarna.si.ticketcenterl.repositories.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class EventTypeService {

    //@Autowired
    private final EventTypeRepository eventTypeRepository;

    public Event_Type creteEventType(Event_Type eventType){
        return eventTypeRepository.save(eventType);
    }

    public Optional<Event_Type> findEventTypeById(Integer id){
        return eventTypeRepository.findEventTypeByEventTypeId(id);
    }

    public List<Event_Type> findAllEventTypes(){
        return eventTypeRepository.findAll();
    }

    public List<Event_Type> findEventTypeByName(String eventTypeName){
        return eventTypeRepository.findEventTypeByEventTypeName(eventTypeName);
    }

    public void deleteEventType(Integer id){
        eventTypeRepository.deleteById(id);
    }
    /*

    public Event_Type createEventType(Event_Type eventType) {
        return eventTypeRepository.save(eventType);
    }

    public void deleteEventType(Long eventTypeId) {
        eventTypeRepository.deleteById(eventTypeId);
    }

    public List<Event_Type> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public Event_Type getEventTypeById(Long eventTypeId) {
        return eventTypeRepository.findEventTypeById(eventTypeId);
    }

    public Event_Type getEventTypeByName(String name) {
        return eventTypeRepository.findEventTypeByName(name);
    }

     */
}
