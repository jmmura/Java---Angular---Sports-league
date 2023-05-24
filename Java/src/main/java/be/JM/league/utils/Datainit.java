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
                    LeagueRepository leagueRepository)
    {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.eventRepository = eventRepository;
        this.gamesRepository = gamesRepository;
        this.leagueRepository = leagueRepository;
    }

    @PersistenceContext
    private EntityManager manager;
    @Override
    public void afterPropertiesSet() throws Exception {
        League footFR = new League();
        footFR.setName("foot FR");

        Player p1 = new Player();
        p1.setFirstName("angel");p1.setLastName("di maria");
        Player p2 = new Player();
        p2.setFirstName("Frank");p2.setLastName("Ribery");


        Team psg = new Team();
        psg.setName("PSG");
        psg.setCity("Paris");
        psg.getPlayers().add(p1);
        Team om = new Team();
        om.setName("OM");
        p2.setTeam(om);

        Game g1 = new Game();
        g1.setHome_team(psg);g1.setExt_team(om);


        Event e = new Event();
        e.setName("Ligue 1");
        e.setBeginning(LocalDate.now());
        e.setEnding(LocalDate.of(2023,8,1));
        e.setLeague(footFR);
        e.getTeams().add(psg);
        e.getTeams().add(om);

        g1.setEvent(e);
        g1.setStart(LocalDateTime.of(2023,6,1,9,0));

        gamesRepository.save(g1);
        playerRepository.save(p1);
        playerRepository.save(p2);
        leagueRepository.save(footFR);
        eventRepository.save(e);
        teamRepository.save(psg);
        teamRepository.save(om);



    }
}