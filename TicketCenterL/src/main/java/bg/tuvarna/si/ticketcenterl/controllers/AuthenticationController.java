package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.models.request.AuthRequest;
import bg.tuvarna.si.ticketcenterl.models.request.RegistrationRequest;
import bg.tuvarna.si.ticketcenterl.models.response.AuthResponse;
import bg.tuvarna.si.ticketcenterl.services.AuthenticationService;
import bg.tuvarna.si.ticketcenterl.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RegistrationService registrationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> userRegistration(@RequestBody RegistrationRequest request){
        AuthResponse response = registrationService.registerUser(request);
        if(response == null) {
            return ResponseEntity.status(HttpStatus.SEE_OTHER).body(null);
        }
        return ResponseEntity.ok(response);
    }
}
