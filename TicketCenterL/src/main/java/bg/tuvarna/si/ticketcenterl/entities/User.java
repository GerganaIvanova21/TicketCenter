package bg.tuvarna.si.ticketcenterl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "User", schema = "public", catalog = "TicketCenter")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "user")

public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private int idUser;

    @Basic
    @Column(name = "fName")
    private String firstName;

    @Basic
    @Column(name = "lName")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;


    @OneToMany(mappedBy = "userNotification", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Notification> notifications = new HashSet<>();
}


