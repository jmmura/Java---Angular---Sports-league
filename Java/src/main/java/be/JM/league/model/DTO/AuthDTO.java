package be.JM.league.model.DTO;

import lombok.Data;

@Data
public class AuthDTO {

    private String username;
    private String token;

    public AuthDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }

}

