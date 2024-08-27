package bg.tuvarna.si.ticketcenterl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellTicketDTO {
    private Integer count;
    private String customerName;
    //private Ticket ticketId;
}
