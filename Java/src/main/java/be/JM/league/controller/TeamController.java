package be.JM.league.controller;

import be.JM.league.model.DTO.TeamDTO;
import be.JM.league.service.LeagueService;
import be.JM.league.service.TeamService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
//@CrossOrigin("*")
public class TeamController {

    private final TeamService teamService;
    private final LeagueService leagueService;

    public TeamController(TeamService teamService,LeagueService leagueService) {
        this.teamService = teamService;
        this.leagueService= leagueService;
    }

    @GetMapping("/all")
    @CrossOrigin("*")
    List<TeamDTO> getAll(){
        return teamService.getAll();
    }


}
