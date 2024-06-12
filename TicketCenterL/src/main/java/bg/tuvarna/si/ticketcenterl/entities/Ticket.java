package bg.tuvarna.si.ticketcenterl.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Table(name = "ticket_id", schema = "public", catalog = "TicketCenter")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int idTicket;

    @Basic
    @Column(name = "type_tic")
    private String type_tic;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "free_seats")
    private int free_seats;

    @Basic
    @Column(name = "occupied_seats")
    private Double occupied_seats;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_type_id", nullable = false)
    private Event eventByEventIdEvent;
}