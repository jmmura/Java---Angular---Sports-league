package be.JM.league.service.implementation;

import be.JM.league.repository.LeagueRepository;
import be.JM.league.service.LeagueService;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public void updateLeague() {

    }
}
