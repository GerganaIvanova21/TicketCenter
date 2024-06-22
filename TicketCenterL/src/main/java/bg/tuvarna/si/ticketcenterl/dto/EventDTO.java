package bg.tuvarna.si.ticketcenterl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String place;
    private Boolean status;
}
