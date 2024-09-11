package bg.tuvarna.si.ticketcenterl.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Table(name = "Ticket", schema = "public", catalog = "TicketCenter")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @Basic
    @Column(name = "type_tic")
    private String ticketType;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "free_seats")
    private Integer free_seats;

    @Basic
    @Column(name = "occupied_seats")
    private Integer occupied_seats;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public String getEventType(){
        return event.getEventType().getEventTypeName();
    }

}