package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    Distributor findDistributorByName(String distributorName);

    Distributor findDistributorById(Long distributorId);

    List<Distributor> getAllDistributors();
}
