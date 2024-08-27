package bg.tuvarna.si.ticketcenterl.models.response;

import bg.tuvarna.si.ticketcenterl.dto.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponse {
    private TicketDTO ticket;
}
