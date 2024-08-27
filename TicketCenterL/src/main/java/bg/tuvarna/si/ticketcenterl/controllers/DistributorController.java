package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.services.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    private DistributorService distributorService;

       // Get all distributors
    @GetMapping
    public List<Distributor> getAllDistributors(){
        return distributorService.getAllDistributors();
    }

    // Get distributor by name
    @GetMapping("/name/{name}")
    public Distributor getDistributorByName(@PathVariable String name){
        return distributorService.getDistributorByName(name);
    }

    // Get distributor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Distributor> getDistributorByDistributorId(@PathVariable Long id) {
        Distributor distributor = distributorService.getDistributorByDistributorId(id);
        return ResponseEntity.ok(distributor);
    }

}
