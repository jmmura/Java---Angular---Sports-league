package be.JM.league.service;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.form.PlayerForm;
import be.JM.league.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    PlayerDTO create(PlayerForm form);
    List<PlayerDTO> getAll();
    PlayerDTO getOne(Long id);
    PlayerDTO update(Long id);


    List<PlayerDTO> getAvailablePlayers();



}
