package be.JM.league.service;

import be.JM.league.model.DTO.GameDTO;
import be.JM.league.model.form.GameForm;

public interface GameService {

    GameDTO create(GameForm form);
    GameDTO getOne(Long id);
    GameDTO update(Long id);
    void delete(Long id);



}
