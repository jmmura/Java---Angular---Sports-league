package be.JM.league.service.implementation;

import be.JM.league.model.DTO.EventDTO;
import be.JM.league.model.DTO.GameDTO;
import be.JM.league.model.DTO.TeamDTO;
import be.JM.league.model.entity.Event;
import be.JM.league.model.entity.Team;
import be.JM.league.model.form.EventForm;
import be.JM.league.repository.EventRepository;
import be.JM.league.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventForm form) {
        Event e = form.toEntity();
        eventRepository.save(e);
        return EventDTO.makeDTO(e);
    }

    @Override
    public List<EventDTO> getAll() {
        return eventRepository.findAll().stream().map(EventDTO::makeDTO).collect(Collectors.toList());
    }

    @Override
    public EventDTO getOne(Long id) {
        return EventDTO.makeDTO(eventRepository.findById(id).orElseThrow());
    }

    @Override
    public EventDTO update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<GameDTO> getGames(Long eventID) {
        return null;
    }

    @Override
    public List<TeamDTO> getTeams(Long eventID) {
        return eventRepository.findById(eventID).orElseThrow().getTeams().stream().map(TeamDTO::makeDTO).collect(Collectors.toList());

    }
}
