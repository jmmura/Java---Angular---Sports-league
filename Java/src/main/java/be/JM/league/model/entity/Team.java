package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long teamID;

    private String name;

    private String coach;

    private String logo = null;

    private String city;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new LinkedHashSet<>();

//    @ManyToMany(mappedBy = "teams")
//    private Set<Game> games = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "teams")
    private Set<Event> competitions;

    @ManyToMany(mappedBy = "teams")
    private Set<League> leagues;


}
