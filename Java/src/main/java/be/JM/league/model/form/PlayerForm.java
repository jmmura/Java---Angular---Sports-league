package be.JM.league.model.form;

import be.JM.league.model.entity.Player;
import be.JM.league.model.entity.Team;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class PlayerForm {

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;

    private String picture;

    public Player toEntity(){

        Player p = new Player();

        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setPicture(picture);

        return p;
    }


}
