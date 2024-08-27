package bg.tuvarna.si.ticketcenterl.models.response;

import bg.tuvarna.si.ticketcenterl.dto.DistributorDTO;
import bg.tuvarna.si.ticketcenterl.dto.EventDTO;
import bg.tuvarna.si.ticketcenterl.dto.SellTicketDTO;
import bg.tuvarna.si.ticketcenterl.dto.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellTicketResponse {
    private DistributorDTO distributor;
    private SellTicketDTO sellTicket;
    private EventDTO event;
    private TicketDTO ticket;
}
