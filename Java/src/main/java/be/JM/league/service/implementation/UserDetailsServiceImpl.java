package be.JM.league.service.implementation;

import be.JM.league.model.DTO.TicketDTO;
import be.JM.league.model.entity.Ticket;
import be.JM.league.repository.TicketRepository;
import be.JM.league.repository.UserRepository;
import be.JM.league.service.TicketService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public UserDetailsServiceImpl(UserRepository userRepository,TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("username not found"));
    }

    /*
    * @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByUsername(username);
    }
    * */

    public TicketDTO buyTicket(Long id){
        Ticket t = ticketRepository.findById(id).orElseThrow();

    }


}
