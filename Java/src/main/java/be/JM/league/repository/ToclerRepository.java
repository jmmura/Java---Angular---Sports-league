package be.JM.league.repository;

import be.JM.league.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToclerRepository extends JpaRepository<Ticket,Long> {
}
