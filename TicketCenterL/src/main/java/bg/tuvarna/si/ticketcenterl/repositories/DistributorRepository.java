package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    Distributor findDistributorByName(String distributorName);

    Distributor findDistributorById(Integer distributorId);
    Distributor findByEventId(Integer eventId);

    //List<Distributor> getAllDistributors();
}
