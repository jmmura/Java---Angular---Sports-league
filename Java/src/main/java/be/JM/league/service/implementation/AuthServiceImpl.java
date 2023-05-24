package be.JM.league.service.implementation;

import be.JM.league.exception.FormValidationException;
import be.JM.league.jwt.JWTHolderDTO;
import be.JM.league.jwt.JwtProvider;
import be.JM.league.model.entity.User;
import be.JM.league.model.form.LoginForm;
import be.JM.league.model.form.RegistrationForm;
import be.JM.league.repository.UserRepository;
import be.JM.league.service.AuthService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegistrationForm form) {
        if(!form.getPassword().equals(form.getConfirmPswd())){
            throw  new FormValidationException("password and confirmpassword should be the same");
        }

        if(userRepository.existsByUsername(form.getUsername())){
            throw  new FormValidationException("username not available");
        }

        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public JWTHolderDTO login(LoginForm form) {

        Authentication auth = new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword());
        auth=authManager.authenticate( auth );
        String token = jwtProvider.createToken((Neo4jProperties.Authentication) auth);

        return  new JWTHolderDTO(token);



    }

}
