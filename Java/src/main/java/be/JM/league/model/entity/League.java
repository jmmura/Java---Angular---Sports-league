package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id", nullable = false)
    private Long id;

    private String name;

    private String logo;

    private String hq_infos;

    @ManyToMany
    @JoinTable(
            name = "leagues_teams",
            joinColumns = @JoinColumn(name = "league_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "league")
    private Set<Event> events = new LinkedHashSet<>();

}
