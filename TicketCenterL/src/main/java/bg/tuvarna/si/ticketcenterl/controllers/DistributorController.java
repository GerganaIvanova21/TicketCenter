package bg.tuvarna.si.ticketcenterl.controllers;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.services.DistributorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/distributors")
@RequiredArgsConstructor
public class DistributorController {
    //@Autowired
    private final DistributorServiceImpl distributorService;

    @GetMapping
    public List<Distributor> findAllDistributors(){
        return distributorService.findAllDistributors();
    }

    @GetMapping("/{id}")
    public Optional<Distributor> findDistributorById(@PathVariable Integer id){
        return distributorService.findDistributorById(id);
    }


    /*public List<Distributor> findDistributorByName(@PathVariable String fName,@PathVariable String lName){
        return distributorService.findDistributorByName(fName, lName);
    }*/

    @GetMapping("/search")
    public ResponseEntity<List<Distributor>> findDistributorByName(@PathVariable String fName, @PathVariable String lName){
        List<Distributor> distributors = distributorService.findDistributorByName(fName, lName);
        if(distributors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(distributors);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<List<Distributor>> findDistributorByEvent(@PathVariable Integer id){
        List<Distributor> distributors = distributorService.findDistributorByEvent(id);
        if(distributors.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(distributors);
    }

    @GetMapping("/rating/{distributorId}")
    public ResponseEntity<Double> calculateRatingBySoldTickets(@PathVariable Integer distributorId){
        double rating = distributorService.calculateRatingBySoldTickets(distributorId);
        return ResponseEntity.ok(rating);
    }


}
