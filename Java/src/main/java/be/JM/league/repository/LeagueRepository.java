package be.JM.league.repository;

import be.JM.league.model.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League,Long> {
}
