package be.JM.league.model.form;

import be.JM.league.model.entity.Game;
import be.JM.league.model.entity.Team;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameForm {

    private LocalDateTime start;

    private Team home;
    private Team ext;

    public Game toEntity(){
        Game g = new Game();

        g.setStart(start);
        ArrayList<Team> teams = new ArrayList<>(2);
        teams.add(0,home);teams.add(1,ext);
        g.setTeams(teams);

        return g;
    }

}
