package bg.tuvarna.si.ticketcenterl.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDataResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
