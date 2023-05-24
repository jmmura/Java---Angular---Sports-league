package be.JM.league.model.DTO;


import be.JM.league.model.entity.Event;
import be.JM.league.model.entity.Team;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class EventDTO {

    private String name;
    private LocalDate beginning;
    private LocalDate ending;

    private Set<String> teams;

    public static EventDTO makeDTO(Event e){
        if(e==null){return null;}
        else{
            return EventDTO.builder()
                    .name(e.getName())
                    .beginning(e.getBeginning())
                    .ending(e.getEnding())
                    .teams(e.getTeams().stream().map(Team::getName).collect(Collectors.toSet()))
                    .build();
        }
    }

}
