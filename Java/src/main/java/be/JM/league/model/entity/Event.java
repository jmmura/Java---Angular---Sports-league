package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

@Entity
@Getter @Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Long id;

    private String name;

    private LocalDate beginning;
    private LocalDate end;

    @ManyToMany
    @JoinTable(
            name = "event_teams",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
//    private TreeMap<Team,Double> ranking = new TreeMap<>();
    private Set<Team> teams = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<Game> games = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;







}
