package be.JM.league.service.implementation;

import be.JM.league.model.DTO.EventDTO;
import be.JM.league.model.DTO.GameDTO;
import be.JM.league.repository.EventRepository;
import be.JM.league.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent() {
        return null;
    }

    @Override
    public List<EventDTO> getEvents() {
        return null;
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
}
