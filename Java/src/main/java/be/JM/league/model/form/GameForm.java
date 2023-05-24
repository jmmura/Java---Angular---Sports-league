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
        g.setExt_team(ext);
        g.setHome_team(home);

        return g;
    }

}
