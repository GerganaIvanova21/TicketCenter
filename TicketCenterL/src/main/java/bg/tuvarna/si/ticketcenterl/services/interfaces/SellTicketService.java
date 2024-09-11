package bg.tuvarna.si.ticketcenterl.services.interfaces;

import bg.tuvarna.si.ticketcenterl.entities.Sell_Ticket;

public interface SellTicketService {
    Sell_Ticket sellTicket(Integer ticketId, Integer distributorId, String customerName, Integer count);

    int countSoldTicketsByDistributor(Integer distributorId);
    int findMinSoldTickets();
    int findMaxSoldTickets();
}
