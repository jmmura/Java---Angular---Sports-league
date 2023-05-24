package be.JM.league.service;

import be.JM.league.model.DTO.EventDTO;
import be.JM.league.model.DTO.GameDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {

    EventDTO createEvent();
    List<EventDTO> getEvents();
    EventDTO update(Long id);
    void delete(Long id);

    List<GameDTO> getGames(Long eventID);
}
