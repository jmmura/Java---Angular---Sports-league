package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

//    @ManyToMany
//    @JoinTable(
//            name = "game_team",
//            joinColumns = @JoinColumn(name = "game_id"),
//            inverseJoinColumns = {
//                    @JoinColumn(table= "Team",name = "home_team"),
//                    @JoinColumn(table = "Team", name = "ext_team")
//            }
//    )
//    private ArrayList<Team> teams = new ArrayList<>(2);

    @ManyToOne
    @JoinColumn(name = "games")
    private Event event = new Event();

    @OneToMany(mappedBy = "game")
    private Set<Ticket> tickets;

}
