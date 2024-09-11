package bg.tuvarna.si.ticketcenterl.entities;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Table(name = "Sell_Ticket", schema = "public", catalog = "TicketCenter")
public class Sell_Ticket {
    @Id
    @Column(name = "sell_id")
    private int sellTicketId;

    @Basic
    @Column(name = "count")
    private Integer count;

    @Basic
    @Column(name = "customer_name")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket tickets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Distributor distributor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


}
