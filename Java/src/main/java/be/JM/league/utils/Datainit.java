package be.JM.league.utils;

import be.JM.league.model.entity.*;
import be.JM.league.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class Datainit implements InitializingBean {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final EventRepository eventRepository;
    private final GamesRepository gamesRepository;
    private final LeagueRepository leagueRepository;

    public Datainit(PlayerRepository playerRepository,
                    TeamRepository teamRepository,
                    EventRepository eventRepository,
                    GamesRepository gamesRepository,
                    LeagueRepository leagueRepository,
                    TicketRepository ticketRepository)
    {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
        this.gamesRepository = gamesRepository;
        this.leagueRepository = leagueRepository;
        this.ticketRepository = ticketRepository;
    }

    @PersistenceContext
    private EntityManager manager;
    private final TicketRepository ticketRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        League footFR = new League();
        footFR.setName("Ligue1");
        leagueRepository.save(footFR);

        Event e = new Event();
        e.setName("Finale");
        e.setBeginning(LocalDate.of(2023,6,1));
        e.setEnding(LocalDate.of(2023,6,1));
        e.setLeague(footFR);
        eventRepository.save(e);

        Team t = new Team();
        t.setCity("Paris");
        t.setName("PSG");
        teamRepository.save(t);
        t=new Team();
        t.setCity("Marseille");
        t.setName("OM");
        teamRepository.save(t);

        Player p = new Player();
        p.setFirstName("Angel");
        p.setLastName("Di Maria");
        p.setTeam(t);
        playerRepository.save(p);

        Game g = new Game();
        g.setStart(LocalDateTime.of(2023,6,1,9,0));
        g.setEvent(e);
        g.setHome_team(t);
        gamesRepository.save(g);

        Ticket tk = new Ticket();
        tk.setGame(g);
        tk.setSeat_type(1);
        tk.setPrice(30);
        ticketRepository.save(tk);
        tk=new Ticket();
        tk.setGame(g);
        tk.setSeat_type(2);
        tk.setPrice(50);
        ticketRepository.save(tk);








    }
}
