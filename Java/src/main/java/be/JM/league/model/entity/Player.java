package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private byte[] picture;

    private int number;

    @OneToMany(mappedBy = "player")
    private Set<Award> awards = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;

}
