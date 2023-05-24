package be.JM.league.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthentificationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JWTAuthentificationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String suffix = "Bearer";
        if( authHeader != null && authHeader.startsWith(suffix) && jwtProvider.validateToken(authHeader.replace(suffix,"")) ){
            Authentication auth = jwtProvider.generateAuth(suffix);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

    }
}
