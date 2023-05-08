package be.JM.league.service;

import be.JM.league.model.DTO.TicketDTO;

public interface TicketService {

    TicketDTO createTicket();
    TicketDTO read(Long id);
    TicketDTO update(Long id);
    void delete(Long id);

}
