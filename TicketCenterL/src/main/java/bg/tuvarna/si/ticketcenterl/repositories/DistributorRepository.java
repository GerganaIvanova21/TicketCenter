package bg.tuvarna.si.ticketcenterl.repositories;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

    List<Distributor> findDistributorByFirstNameAndLastName(String firstName, String lastName);
    /*@Query("SELECT d FROM Distributor d WHERE d.firstName = :firstName AND d.lastName = :lastName")
    List<Distributor> findDistributorByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
     */
    //@Query("SELECT d FROM Distributor d JOIN d.eventsByDistributor e WHERE e.idEvent = :eventID")
   // List<Distributor> findDistributorByEvent(Integer eventID);

    //@Query("SELECT d FROM Distributor d JOIN d.eventsByDistributor e WHERE e.eventId = :eventID")
    List<Distributor> findByEventsByDistributor_EventId(Integer eventID);

    Optional<Distributor> findDistributorById(Integer distributorId);



    //List<Distributor> getAllDistributors();
}
