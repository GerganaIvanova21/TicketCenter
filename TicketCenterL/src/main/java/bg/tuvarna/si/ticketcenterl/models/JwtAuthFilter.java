package bg.tuvarna.si.ticketcenterl.models;
/*
import bg.tuvarna.si.ticketcenterl.services.JwtService;
import bg.tuvarna.si.ticketcenterl.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String email= null;
        if(authHeader != null && authHeader.startsWith("Bearer")){
            token = authHeader.substring(7);
            email = jwtService.extractEmail(token);
        }

        if (email !=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.lo
        }

    }


}
*/