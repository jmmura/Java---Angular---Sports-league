package be.JM.league.service;

import be.JM.league.model.DTO.EventDTO;
import be.JM.league.model.DTO.GameDTO;
import be.JM.league.model.DTO.TeamDTO;
import be.JM.league.model.form.EventForm;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {

    EventDTO createEvent(EventForm form);
    List<EventDTO> getAll();
    EventDTO getOne(Long id);
    EventDTO update(Long id);
    void delete(Long id);

    List<GameDTO> getGames(Long eventID);
    List<TeamDTO> getTeams(Long eventID);
}
