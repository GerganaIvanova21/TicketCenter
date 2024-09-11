package bg.tuvarna.si.ticketcenterl.services.interfaces;

import bg.tuvarna.si.ticketcenterl.entities.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface OrganizerService {
    Event createEvent(String name, String description, LocalDate date, LocalTime time, String place, Integer eventTypeId,
                      Boolean status, Integer organizerId, Set<Integer> distributorIds);

    Event updateEvent(Integer eventID, String name, String description, LocalDate date, LocalTime time, String place,
                      Boolean status, Set<Integer> distributorIds, Integer eventTypeId);

    /*Event assignDistributorsToEvent(Integer eventID, List<Distributor>distributors);*/
}
