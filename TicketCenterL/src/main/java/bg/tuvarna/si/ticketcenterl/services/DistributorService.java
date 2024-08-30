package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@ReadingConverter
public class DistributorService {
    @Autowired
    private final DistributorRepository distributorRepository;

    private Distributor createDistributor(Distributor distributor){
        return distributorRepository.save(distributor);
    }

    private List<Distributor> findAllDistributors(){
        return distributorRepository.findAll();
    }

    private Distributor findDistributorById(Integer id){
        return distributorRepository.findDistributorById(id);
    }

    private List<Distributor> findDistributorByName(String fName, String lName){
        return distributorRepository.findDistributorByName(fName, lName);
    }

    private List<Distributor> findDistributorByEvent(Integer id){
        return distributorRepository.findDistributorByEvent(id);
    }

    private void deleteDistributor(Integer id){
        distributorRepository.deleteById(id);
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
