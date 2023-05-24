package be.JM.league.service;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.DTO.TeamDTO;
import be.JM.league.model.form.TeamForm;

import java.util.List;

public interface TeamService {

    TeamDTO createTeam(TeamForm form);
    void DeleteTeam(Long id);
    TeamDTO updateTeam(Long id);

    List<PlayerDTO> getPlayers(Long id);

    List<TeamDTO> getAll();




}
