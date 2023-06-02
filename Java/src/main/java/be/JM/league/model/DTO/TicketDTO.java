package be.JM.league.model.DTO;

import be.JM.league.model.entity.Ticket;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDTO {

    private long gameId;

    private int seating_type;

    private double price;

    public static TicketDTO makeDTO(Ticket t){
        if(t==null){return null;}
        else{
            return TicketDTO.builder()
                    .gameId(t.getGame().getId())
                    .seating_type(t.getSeat_type())
                    .price(t.getPrice())
                    .build();
        }
    }


}
