package be.JM.league.model.DTO;


import be.JM.league.model.entity.Player;
import be.JM.league.model.entity.Team;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
public class PlayerDTO {

    private String lastName;

    private String firstName;

    private String team;

    public static PlayerDTO makeDTO(Player p){
        if(p==null){return null;}
        else{
            return PlayerDTO.builder()
                    .lastName(p.getLastName())
                    .firstName(p.getFirstName())
                    .team(p.getTeam().getName())
                    .build();
        }
    }

}
