package be.JM.league.model.entity;

import be.JM.league.model.form.TeamForm;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "game_id", nullable = false)
    private Long id;

    private LocalDateTime start;

    private int homeScore;
    private int extScore;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team home_team;

    @ManyToOne
    @JoinColumn(name = "ext_team_id")
    private Team ext_team;


    @ManyToOne
    @JoinColumn(name = "games")
    private Event event;

    @OneToMany(mappedBy = "game")
    private Set<Ticket> tickets;

    /*
    *
    * */

}
