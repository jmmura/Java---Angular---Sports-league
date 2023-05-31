package be.JM.league.controller;


import be.JM.league.jwt.JWTHolderDTO;
import be.JM.league.model.form.LoginForm;
import be.JM.league.model.form.RegistrationForm;
import be.JM.league.service.AuthService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
//@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegistrationForm form){
        authService.register(form);
    }

    @PostMapping("/sign_in")
    public JWTHolderDTO login(@RequestBody @Valid LoginForm form){
        return authService.login(form);
    }


}




