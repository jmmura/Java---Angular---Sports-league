package be.JM.league.service.implementation;

import be.JM.league.model.DTO.GameDTO;
import be.JM.league.model.entity.Game;
import be.JM.league.model.entity.Ticket;
import be.JM.league.model.form.GameForm;
import be.JM.league.repository.GamesRepository;
import be.JM.league.repository.TicketRepository;
import be.JM.league.service.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GamesRepository _gameRepository;
    private final TicketRepository _ticketRepository;

    public GameServiceImpl(GamesRepository _gamesRepository, TicketRepository ticketRepository) {
        this._gameRepository = _gamesRepository;
        _ticketRepository = ticketRepository;
    }

    @Override
    public GameDTO create(GameForm form) {
        Game g = form.toEntity();
        this._gameRepository.save(g);
        Ticket t = new Ticket();
        return GameDTO.makeDTO(g);
    }

    @Override
    public GameDTO getOne(Long id) {
        return GameDTO.makeDTO(_gameRepository.findById(id).orElseThrow());
    }

    @Override
    public GameDTO update(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
