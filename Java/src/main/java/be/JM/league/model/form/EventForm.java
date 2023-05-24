package be.JM.league.model.form;

import be.JM.league.model.entity.Event;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class EventForm {

    @NotNull
    private String name;

    @NotNull
    private LocalDate beginning;

    @NotNull
    private LocalDate ending;



    public Event toEntity(){
        Event e = new Event();

        e.setBeginning(beginning);
        e.setEnding(ending);
        e.setName(name);

        return e;
    }
}
