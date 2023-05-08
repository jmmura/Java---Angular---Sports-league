package be.JM.league.controller;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.form.PlayerForm;
import be.JM.league.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public PlayerDTO create(@RequestBody PlayerForm form){
        return playerService.create(form);
    }

}
