package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.Year;

@Entity
@Getter @Setter
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "award_id", nullable = false)
    private Long id;

    private String name;
    private Year year;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

}
