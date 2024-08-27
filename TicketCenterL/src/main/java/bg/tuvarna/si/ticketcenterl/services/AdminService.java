package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class AdminService {
    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private DistributorRepository distributorRepository;


    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(id);
        if (optionalOrganizer.isPresent()) {
            Organizer organizer = optionalOrganizer.get();
            organizer.setFirstName(organizerDetails.getFirstName());
            organizer.setLastName(organizerDetails.getLastName());
            organizer.setEmail(organizerDetails.getEmail());
            organizer.setPassword(organizerDetails.getPassword());
            organizer.setHonor(organizerDetails.getHonor());
            return organizerRepository.save(organizer);
        } else {
            throw new RuntimeException("Organizer not found");
        }
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Distributor createDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public Distributor updateDistributor(Long id, Distributor distributorDetails) {
        Optional<Distributor> optionalDistributor = distributorRepository.findById(id);
        if (optionalDistributor.isPresent()) {
            Distributor distributor = optionalDistributor.get();
            distributor.setFirstName(distributorDetails.getFirstName());
            distributor.setLastName(distributorDetails.getLastName());
            distributor.setEmail(distributorDetails.getEmail());
            distributor.setPassword(distributorDetails.getPassword());
            distributor.setHonor(distributorDetails.getHonor());
            distributor.setRating(distributorDetails.getRating());
            return distributorRepository.save(distributor);
        } else {
            throw new RuntimeException("Distributor not found");
        }
    }

    public void deleteDistributor(Long id) {
        distributorRepository.deleteById(id);
    }

    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }
}
