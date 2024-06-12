package bg.tuvarna.si.ticketcenterl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue(value = "distributor")

public class Distributor extends User {
    @Basic
    @Column(name = "honor")
    private Double honor;

    @Basic
    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Distributor_Event",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<Event> eventsByDistributor = new HashSet<>();

    @OneToMany(mappedBy = "distributor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sell_Ticket> sellTickets;
}

