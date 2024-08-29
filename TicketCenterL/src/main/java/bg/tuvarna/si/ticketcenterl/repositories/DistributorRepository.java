package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    @Query("SELECT d FROM Distributor d WHERE d.firstName = :firstName AND d.lastName = :lastName")
    List<Distributor> findDistributorByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT d FROM Distributor d JOIN d.eventsByDistributor e WHERE e.idEvent = :eventID")
    List<Distributor> findDistributorByEvent(@Param("event_ID") Integer eventID);

    Distributor findDistributorById(Integer distributorId);



    //List<Distributor> getAllDistributors();
}
