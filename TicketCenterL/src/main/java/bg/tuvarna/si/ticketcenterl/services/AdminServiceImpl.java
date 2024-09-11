package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.OrganizerRepository;
import bg.tuvarna.si.ticketcenterl.services.interfaces.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class AdminServiceImpl implements AdminService {
    private final OrganizerRepository organizerRepository;
    private final DistributorRepository distributorRepository;

    @Override
    public Organizer createOrganizer(String firstName, String lastName, String email, String password, Double honor){
        Organizer organizer = Organizer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .honor(honor)
                .build();

        return organizerRepository.save(organizer);
    }

    @Override
    public  Organizer updateOrganizer(Integer id, String firstName, String lastName, String email, String password, Double honor){
        Organizer organizer =organizerRepository.findOrganizerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Organizer not found"));
        organizer.setFirstName(firstName);
        organizer.setLastName(lastName);
        organizer.setEmail(email);
        organizer.setPassword(password);
        organizer.setHonor(honor);

        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Integer id){
        organizerRepository.deleteById(id);
    }


    @Override
    public Distributor createDistributor(String firstName, String lastName, String email, String password, Double honor, Double rating){
        Distributor distributor = Distributor.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .honor(honor)
                .rating(rating)
                .build();
        return distributorRepository.save(distributor);
    }

    @Override
    public Distributor updateDistributor(Integer distributorId, String firstName, String lastName, String email, String password, Double honor, Double rating){
        Distributor distributor = distributorRepository.findDistributorById(distributorId)
                .orElseThrow(() -> new IllegalArgumentException("Distributor not found"));

        distributor.setFirstName(firstName);
        distributor.setLastName(lastName);
        distributor.setEmail(email);
        distributor.setPassword(password);
        distributor.setHonor(honor);
        distributor.setRating(rating);

        return distributorRepository.save(distributor);
    }

    public void deleteDistributor(Integer id){
        distributorRepository.deleteById(id);
    }



    /*public Organizer createOrganizer(Organizer organizer) {
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
    }*/
}
