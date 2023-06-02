package be.JM.league.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", nullable = false)
    private Long id;

    private int seat_type;

    private double price;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game = new Game();

    @ManyToMany(mappedBy = "tickets")
    private Set<User> spectators;



}
