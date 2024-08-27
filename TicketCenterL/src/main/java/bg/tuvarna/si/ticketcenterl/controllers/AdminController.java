package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.services.AdminService;
import bg.tuvarna.si.ticketcenterl.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
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
    }
}
