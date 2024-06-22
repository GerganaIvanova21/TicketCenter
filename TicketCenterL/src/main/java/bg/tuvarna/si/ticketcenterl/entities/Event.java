package bg.tuvarna.si.ticketcenterl.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Event", schema = "public", catalog = "TicketCenter")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_ID")
    private int idEvent;

    @Basic
    @Column(name="name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "date")
    private LocalDate date;

    @Basic
    @Column(name = "time")
    private LocalTime time;

    @Basic
    @Column(name = "place")
    private String place;

    @Basic
    @Column(name = "status")
    private Boolean status;

    @ManyToMany(mappedBy = "eventsByDistributor", fetch = FetchType.EAGER)
    private Set<Distributor> distribEvent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_type_id", nullable = false)
    private Event_Type eventType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private Organizer organizer;

    @OneToMany(mappedBy = "eventsByEventIdEvent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ticket> ticketByIdEvent = new HashSet<>();

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sell_Ticket> sellTickets = new HashSet<>();

    /*public void addSellTicket(Sell_Ticket ticket){
        sellTickets.add(ticket);
    }*/

}
