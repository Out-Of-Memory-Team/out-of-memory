package dev.butane.oom.oombackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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
        UsernamePasswordAuthenticationToken authentication = parseToken(request);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken parseToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            String claims = token.replace("Bearer ", "");
            try {
                Jws<Claims> claimsJws = Jwts.parser()
                        .setSigningKey(jwtSecret.getBytes())
                        .parseClaimsJws(claims);

                String username = claimsJws.getBody().getSubject();

                if (username.isEmpty() || username == null) {
                    return null;
                }

                // TODO roles here!

                return new UsernamePasswordAuthenticationToken(username, null, null);
            } catch (JwtException exception) {

            }
        }

        return null;
    }
}
