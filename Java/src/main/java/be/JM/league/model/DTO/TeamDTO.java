package be.JM.league.model.DTO;

import be.JM.league.model.entity.Team;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDTO {

    private String name;
    private String city;

    public static TeamDTO makeDTO(Team t){
        if(t==null){return null;}
        else{
            return TeamDTO.builder()
                    .name(t.getName())
                    .city(t.getCity())
                    .build();
        }
    }

}
