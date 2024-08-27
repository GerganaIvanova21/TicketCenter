package bg.tuvarna.si.ticketcenterl.services;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Event;
import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;
import bg.tuvarna.si.ticketcenterl.repositories.DistributorRepository;
import bg.tuvarna.si.ticketcenterl.repositories.EventRepository;
import bg.tuvarna.si.ticketcenterl.repositories.SellTicketRepository;
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
    }
}
