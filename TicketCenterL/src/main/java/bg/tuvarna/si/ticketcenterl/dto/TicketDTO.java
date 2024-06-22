package bg.tuvarna.si.ticketcenterl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO {
    private String ticketType;
    private Double price;
    private Integer freeSeats;
    private Integer occupiedSeats;
}
