package be.JM.league.model.form;

import be.JM.league.model.entity.Team;

import javax.validation.constraints.NotNull;

public class TeamForm {

    @NotNull
    private String name;

    @NotNull
    private String city;

    private String coach;

    private String logo;

    public Team toEntity(){
        Team t = new Team();

        t.setCity(city);
        t.setName(name);
        t.setCoach(coach);
        t.setLogo(logo);

        return t;
    }

}
