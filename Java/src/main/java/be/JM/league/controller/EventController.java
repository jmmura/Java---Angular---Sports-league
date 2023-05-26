package be.JM.league.controller;

import be.JM.league.model.DTO.EventDTO;
import be.JM.league.model.form.EventForm;
import be.JM.league.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping("/new")
    public EventDTO create(@RequestBody EventForm form){
        return eventService.createEvent(form);
    }

    @GetMapping("/all")
    public List<EventDTO> getAll(){
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public EventDTO getOne(@PathVariable Long id){
        return eventService.getOne(id);
    }
}
