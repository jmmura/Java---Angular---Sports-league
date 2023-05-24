package be.JM.league.controller;

import be.JM.league.service.EventService;
import be.JM.league.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@CrossOrigin("*")
public class GameController {

    private final GameService gameService;
    private final EventService eventService;

    public GameController(GameService gameService, EventService eventService) {
        this.gameService = gameService;
        this.eventService = eventService;
    }
}
