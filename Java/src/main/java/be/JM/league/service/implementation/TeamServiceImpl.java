package be.JM.league.service.implementation;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.DTO.TeamDTO;
import be.JM.league.model.entity.Team;
import be.JM.league.model.form.TeamForm;
import be.JM.league.repository.TeamRepository;
import be.JM.league.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository _teamRepository;

    public TeamServiceImpl(TeamRepository _tealRepository) {
        this._teamRepository = _tealRepository;
    }

    @Override
    public TeamDTO createTeam(TeamForm form) {
        Team t = form.toEntity();
        _teamRepository.save(t);
        return TeamDTO.makeDTO(t);
    }

    @Override
    public void DeleteTeam(Long id) {
    }

    @Override
    public TeamDTO updateTeam(Long id) {
        return null;
    }

    @Override
    public List<PlayerDTO> getPlayers(Long id) {
        Team t = _teamRepository.findById(id).orElseThrow();
        return t.getPlayers().stream().map(PlayerDTO::makeDTO).collect(Collectors.toList());
    }

    @Override
    public List<TeamDTO> getAll(){
        List<Team> teams = _teamRepository.findAll();
        return teams.stream().map(TeamDTO::makeDTO).collect(Collectors.toList());
    }
}
