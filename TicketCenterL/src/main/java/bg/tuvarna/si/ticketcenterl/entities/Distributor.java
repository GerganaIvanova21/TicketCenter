package bg.tuvarna.si.ticketcenterl.entities;

import bg.tuvarna.si.ticketcenterl.type.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue(value = "Distributor")

public class Distributor extends User {
    @Basic
    @Column(name = "honor")
    private Double honor;

    @Basic
    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Distributor_Event",joinColumns = @JoinColumn(name = "user_ID"),
            inverseJoinColumns = @JoinColumn(name = "event_ID"))
    private Set<Event> eventsByDistributor = new HashSet<>();

    @OneToMany(mappedBy = "distributor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sell_Ticket> sellTickets;

    @Builder
    public Distributor(Integer id, String firstName, String lastName, String email, String password, Double honor, Double rating){
        super(id, firstName, lastName, email, password, Role.Distributor);
        this.honor = honor;
        this.rating=rating;
    }


}

