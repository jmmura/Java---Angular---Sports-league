package be.JM.league.service;

import be.JM.league.jwt.JWTHolderDTO;
import be.JM.league.model.form.LoginForm;
import be.JM.league.model.form.RegistrationForm;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public void register(RegistrationForm form);
    public JWTHolderDTO login(LoginForm form);
}
