package be.JM.league.repository;

import be.JM.league.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Game,Long> {
}
