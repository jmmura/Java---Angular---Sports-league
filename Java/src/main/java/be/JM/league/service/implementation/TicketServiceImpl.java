package be.JM.league.service.implementation;

import be.JM.league.model.DTO.TicketDTO;
import be.JM.league.model.entity.Ticket;
import be.JM.league.repository.TicketRepository;
import be.JM.league.service.TicketService;

import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketDTO createTicket() {
        return null;
    }

    @Override
    public TicketDTO read(Long id) {
        return TicketDTO.makeDTO(ticketRepository.findById(id).orElseThrow());
    }

    @Override
    public TicketDTO update(Long id, int seat_type, double price) {
        Ticket t = ticketRepository.findById(id).orElseThrow();
        t.setSeat_type(seat_type);
        t.setPrice(price);
        ticketRepository.save(t);
        return TicketDTO.makeDTO(t);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketDTO> getAll() {
        return ticketRepository.findAll().stream().map(TicketDTO::makeDTO).collect(Collectors.toList());
    }

    @Override
    public TicketDTO buyTicket(Long id){
        Ticket t = new Ticket();

    }

    public Ticket getOne(Long id){
        return ticketRepository.findById(id).orElseThrow();
    }
}
