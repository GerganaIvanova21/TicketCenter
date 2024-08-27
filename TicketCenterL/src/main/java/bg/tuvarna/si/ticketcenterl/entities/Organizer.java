package bg.tuvarna.si.ticketcenterl.entities;

import bg.tuvarna.si.ticketcenterl.type.Role;
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
//@DiscriminatorValue(value = "organizer")
public class Organizer extends User {
    @Basic
    @Column(name = "honor")
    private Double honor;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events = new HashSet<>();

    public Organizer(Integer id, String firstName, String lastName, String email, String password, Double honor){
        super(id, firstName, lastName, email, password, Role.Distributor);
        this.honor = honor;
    }

}