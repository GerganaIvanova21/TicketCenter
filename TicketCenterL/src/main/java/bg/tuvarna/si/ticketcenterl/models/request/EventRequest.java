package bg.tuvarna.si.ticketcenterl.models.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data

public class EventRequest {
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private Boolean status;
    private Integer eventTypeId;
    private Integer organizerId;
    private Set<Integer> distributorIds;
}
