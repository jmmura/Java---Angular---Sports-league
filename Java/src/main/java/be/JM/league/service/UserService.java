package be.JM.league.service;


import be.JM.league.jwt.JWTHolderDTO;
import be.JM.league.model.form.LoginForm;
import be.JM.league.model.form.RegistrationForm;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface UserService {

    void register (RegistrationForm form);

    JWTHolderDTO login (LoginForm form);


}
