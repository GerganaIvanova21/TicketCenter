package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.models.request.UserRequest;
import bg.tuvarna.si.ticketcenterl.models.response.UserDataResponse;
import bg.tuvarna.si.ticketcenterl.models.response.UserResponse;
import bg.tuvarna.si.ticketcenterl.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserData(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.getUserByEmail(request.getEmail()));
    }

    @GetMapping("data")
    public ResponseEntity<UserDataResponse> getUserData(@CurrentSecurityContext(expression = "authentication")Authentication authentication){
        return ResponseEntity.ok(userService.getUserData(authentication.getName()));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

}
