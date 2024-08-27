package bg.tuvarna.si.ticketcenterl.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class SellTicketRequest {
    private String distributorName;
    private String customerName;
    private String event;
    private String ticket;

}
