package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.config.SecurityConfig;
import bg.tuvarna.si.ticketcenterl.entities.Admin;
import bg.tuvarna.si.ticketcenterl.models.request.AuthRequest;
import bg.tuvarna.si.ticketcenterl.models.request.RegistrationRequest;
import bg.tuvarna.si.ticketcenterl.models.response.AuthResponse;
import bg.tuvarna.si.ticketcenterl.repositories.UserRepository;
import bg.tuvarna.si.ticketcenterl.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

@Service
@ReadingConverter
@RequiredArgsConstructor
public class RegistrationService {
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;
    private final SecurityConfig securityConfig;

    public AuthResponse registerUser(RegistrationRequest request){
        var user= userRepository.findByEmail(request.getEmail());

        if(user.isPresent()){
            return null;
        }

        Admin register = new Admin();
        register.setEmail(request.getEmail());
        register.setPassword(securityConfig.passwordEncoder().encode(request.getPassword()));
        register.setFirstName(request.getFirstName());
        register.setLastName(request.getLastName());
        register.setRole(Role.Admin);
        userRepository.save(register);

        return authenticationService.authenticate(
                new AuthRequest(request.getEmail(), request.getPassword()));

    }
}
