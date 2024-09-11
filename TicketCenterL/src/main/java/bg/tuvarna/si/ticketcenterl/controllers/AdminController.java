package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.services.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor

public class AdminController {

    //@Autowired
    private final AdminServiceImpl adminService;

    @PostMapping("/create-organizer")
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer){
        Organizer createdOrganizer = adminService.createOrganizer(
                organizer.getFirstName(),
                organizer.getLastName(),
                organizer.getEmail(),
                organizer.getPassword(),
                organizer.getHonor()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganizer);
    }

    @PutMapping("/update-organizer/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Integer id, @RequestBody Organizer organizer){
        Organizer updatedOrganizer = adminService.updateOrganizer(
                id,
                organizer.getFirstName(),
                organizer.getLastName(),
                organizer.getEmail(),
                organizer.getPassword(),
                organizer.getHonor()
        );
        return ResponseEntity.ok(updatedOrganizer);
    }
    @DeleteMapping("/organizer/{id}")
    public void deleteOrganizer(@PathVariable Integer id){
        adminService.deleteOrganizer(id);
    }

    @PostMapping("create-distributor")
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor){
        Distributor createdDistributor = adminService.createDistributor(
                distributor.getFirstName(),
                distributor.getLastName(),
                distributor.getEmail(),
                distributor.getPassword(),
                distributor.getHonor(),
                distributor.getRating()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDistributor);
    }

    @PutMapping("update-distributor/{id}")
    public ResponseEntity<Distributor> updateDistributor(@PathVariable Integer id, @RequestBody Distributor distributor){
        Distributor updatedDistributor = adminService.updateDistributor(
                id,
                distributor.getFirstName(),
                distributor.getLastName(),
                distributor.getEmail(),
                distributor.getPassword(),
                distributor.getHonor(),
                distributor.getRating()
        );
        return ResponseEntity.ok(updatedDistributor);
    }

    @DeleteMapping("/distributor/{id}")
    public void deleteDistributor(@PathVariable Integer id){
        adminService.deleteDistributor(id);
    }


    /*
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrganizerService organizerService;


    // Create Organizer
    @PostMapping("/organizers")
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        Organizer createdOrganizer = adminService.createOrganizer(organizer);
        return ResponseEntity.ok(createdOrganizer);
    }

    // Update Organizer
    @PutMapping("/organizers/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizerDetails) {
        Organizer updatedOrganizer = adminService.updateOrganizer(id, organizerDetails);
        return ResponseEntity.ok(updatedOrganizer);
    }

    // Delete Organizer
    @DeleteMapping("/organizers/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        adminService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }
    // Get All Organizers
    @GetMapping("/organizers")
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = adminService.getAllOrganizers();
        return ResponseEntity.ok(organizers);
    }

    // Create Distributor
    @PostMapping("/distributors")
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor) {
        Distributor createdDistributor = adminService.createDistributor(distributor);
        return ResponseEntity.ok(createdDistributor);
    }

    // Update Distributor
    @PutMapping("/distributors/{id}")
    public ResponseEntity<Distributor> updateDistributor(@PathVariable Long id, @RequestBody Distributor distributorDetails) {
        Distributor updatedDistributor = adminService.updateDistributor(id, distributorDetails);
        return ResponseEntity.ok(updatedDistributor);
    }

    // Delete Distributor
    @DeleteMapping("/distributors/{id}")
    public void deleteDistributor(@PathVariable Long id) {
        adminService.deleteDistributor(id);
    }

    // Get All Distributors
    @GetMapping("/distributors")
    public ResponseEntity<List<Distributor>> getAllDistributors() {
        List<Distributor> distributors = adminService.getAllDistributors();
        return ResponseEntity.ok(distributors);
    }*/
}
