package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.models.request.AuthRequest;
import bg.tuvarna.si.ticketcenterl.models.response.AuthResponse;
import bg.tuvarna.si.ticketcenterl.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@ReadingConverter
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthResponse authenticate (AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
        );

        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .accessToken(jwtToken)
                .build();
    }
}
