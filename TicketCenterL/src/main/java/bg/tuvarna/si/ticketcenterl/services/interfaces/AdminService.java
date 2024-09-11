package bg.tuvarna.si.ticketcenterl.services.interfaces;

import bg.tuvarna.si.ticketcenterl.entities.Distributor;
import bg.tuvarna.si.ticketcenterl.entities.Organizer;

public interface AdminService {
    Organizer createOrganizer(String firstName, String lastName, String email, String password, Double honor);

    Organizer updateOrganizer(Integer id, String firstName, String lastName, String email, String password, Double honor);

    Distributor createDistributor(String firstName, String lastName, String email, String password, Double honor, Double rating);

    Distributor updateDistributor(Integer distributorId, String firstName, String lastName, String email, String password, Double honor, Double rating);
}
