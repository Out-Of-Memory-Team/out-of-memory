package dev.butane.oom.oombackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private String jwtAudience;
    private String jwtIssuer;
    private String jwtSecret;
    private String jwtType;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, String jwtAudience, String jwtIssuer, String jwtSecret, String jwtType) {
        super(authenticationManager);
        this.jwtAudience = jwtAudience;
        this.jwtIssuer = jwtIssuer;
        this.jwtSecret = jwtSecret;
        this.jwtType = jwtType;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = getToken(request);
        String username = parseToken(token);
        UsernamePasswordAuthenticationToken authentication = getUsernamePasswordAuth(username);
        
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }

    private String parseToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts
                    .parserBuilder().setSigningKey(jwtSecret.getBytes())
                    .build().parseClaimsJws(token);

            return claimsJws.getBody().getSubject();
        } catch (JwtException exception) {
            return null;
        }
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuth(String username) {
        if (username.isEmpty() || username == null) {
            return null;
        }

        //TODO: roles here!

        return new UsernamePasswordAuthenticationToken(username, null, null);
    }
}
