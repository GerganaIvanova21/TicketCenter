package bg.tuvarna.si.ticketcenterl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "Event_Type", schema = "public", catalog = "TicketCenter")
public class Event_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_ID")
    private int eventTypeId;

    @Basic
    @Column(name = "event_type")
    private String eventTypeName;

    @OneToMany(mappedBy = "eventType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> eventsByIdEventType = new HashSet<>();


}