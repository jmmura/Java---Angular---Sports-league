package be.JM.league.model.DTO;

import be.JM.league.model.entity.Game;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class GameDTO {

    private LocalDate date;
    private LocalTime start;

    private String homeTeam;
    private String extTeam;

    private int homeScore;
    private int extScore;

    private String place;

    public static  GameDTO makeDTO(Game g){
        if(g==null){return null;}
        else{
            return GameDTO.builder()
                    .date(g.getStart().toLocalDate())
                    .start(g.getStart().toLocalTime())
                    .homeTeam(g.getHome_team().getName())
                    .extTeam(g.getExt_team().getName())
                    .homeScore(g.getHomeScore())
                    .extScore(g.getExtScore())
                    .place(g.getHome_team().getCity())
                    .build();
        }
    }

}
