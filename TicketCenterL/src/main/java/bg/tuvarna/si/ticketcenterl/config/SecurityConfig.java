package bg.tuvarna.si.ticketcenterl.config;

import org.springframework.beans.factory.annotation.Autowired;

public class SecurityConfig {
    @Autowired

    private JwtAuthFilter authFilter;

}
