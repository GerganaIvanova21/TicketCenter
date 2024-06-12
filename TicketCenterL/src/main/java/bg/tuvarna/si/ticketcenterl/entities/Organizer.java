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
@DiscriminatorValue(value = "organizer")
public class Organizer extends User {
    @Basic
    @Column(name = "honor")
    private Double honor;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events = new HashSet<>();
}