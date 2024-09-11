package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.SellTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class DistributorServiceImpl {
    private final DistributorRepository distributorRepository;
    private final SellTicketRepository sellTicketRepository;

    public double calculateRatingBySoldTickets(Integer distributorId){
        int ticketsSoldByDistributor = sellTicketRepository.countTicketsSoldByDistributorId(distributorId);

        int minSoldTickets= sellTicketRepository.findMinTicketsSold();
        int maxSoldTickets = sellTicketRepository.findMaxTicketsSold();

        return rating(ticketsSoldByDistributor, minSoldTickets, maxSoldTickets);
    }

    private double rating(int soldTickets, int minSoldTickets, int maxSoldTickets){
        if(maxSoldTickets == maxSoldTickets){  //при еднакъв брой продадени билети
            return 5.0;
        }
        return 1 + (double) (soldTickets - minSoldTickets) / (maxSoldTickets - minSoldTickets)*4;
    }

    public List<Distributor> findAllDistributors(){
        return distributorRepository.findAll();
    }

    public Optional<Distributor> findDistributorById(Integer id){
        return distributorRepository.findDistributorById(id);
    }

    public List<Distributor> findDistributorByName(String firstName, String lastName){
        return distributorRepository.findDistributorByFirstNameAndLastName(firstName, lastName);
    }

    public List<Distributor> findDistributorByEvent(Integer eventID){
        return distributorRepository.findByEventsByDistributor_EventId(eventID);
    }



    /*@Autowired
    private DistributorRepository distributorRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SellTicketRepository sellTicketRepository;

    public List<Sell_Ticket> getSoldTicketsByDistributor(Long distributorId) {
        return sellTicketRepository.findByDistributorId(distributorId);
    }

    public Distributor getDistributorByName(String name) {
        return distributorRepository.findDistributorByName(name);
    }

    public Distributor getDistributorByDistributorId(Long distributorId) {
        return distributorRepository.findDistributorById(distributorId);
    }

    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }*/
}
