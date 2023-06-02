package be.JM.league.service;

import be.JM.league.model.DTO.TicketDTO;
import be.JM.league.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    TicketDTO createTicket();
    TicketDTO read(Long id);
    TicketDTO update(Long id, int seat_type, double price);
    void delete(Long id);

    List<TicketDTO> getAll();
    TicketDTO buyTicket(Long id);

}
