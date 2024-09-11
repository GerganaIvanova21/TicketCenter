package bg.tuvarna.si.ticketcenterl.entities;

import bg.tuvarna.si.ticketcenterl.type.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "Admin")

public class Admin extends User {


    @Builder
    public Admin(Integer id, String firstName, String lastName, String email,String password){
        super(id, firstName, lastName, email, password, Role.Admin);
    }
}
