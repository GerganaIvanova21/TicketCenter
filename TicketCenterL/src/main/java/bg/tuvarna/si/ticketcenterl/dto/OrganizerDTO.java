package bg.tuvarna.si.ticketcenterl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    private String firstName;
    private String lastName;
    private Double honor;
}
