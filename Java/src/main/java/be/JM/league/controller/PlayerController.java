package be.JM.league.controller;

import be.JM.league.model.DTO.PlayerDTO;
import be.JM.league.model.form.PlayerForm;
import be.JM.league.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin("*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public PlayerDTO create(@RequestBody PlayerForm form){
        return playerService.create(form);
    }

    @GetMapping("/{id}")
    public PlayerDTO getOne(@PathVariable Long id){
        return playerService.getOne(id);
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAll(){
        return playerService.getAll();
    }

}
