package bg.tuvarna.si.ticketcenterl.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "notification", schema = "public", catalog = "TicketCenter")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private int id;

    @Basic
    @Column(name = "message")
    private String message;

    @Basic
    @Column(name = "senn")
    private Boolean seen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User userNotification;
}