package be.JM.league.service.implementation;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.entity.Player;
import be.JM.league.model.form.PlayerForm;
import be.JM.league.repository.PlayerRepository;
import be.JM.league.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository _playerRepository;

    public PlayerServiceImpl(PlayerRepository _playerRepository) {
        this._playerRepository = _playerRepository;
    }

    @Override
    public PlayerDTO create(PlayerForm form) {
        Player p = form.toEntity();
        _playerRepository.save(p);
        return PlayerDTO.makeDTO(p);
    }

    @Override
    public PlayerDTO getOne(Long id) {
        return PlayerDTO.makeDTO(_playerRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PlayerDTO> getAll(){
        return _playerRepository.findAll().stream().map(PlayerDTO::makeDTO).collect(Collectors.toList());
    }

    @Override
    public PlayerDTO update(Long id) {
        return null;
    }

    @Override
    public List<PlayerDTO> getAvailablePlayers() {
        return null;
    }
}
