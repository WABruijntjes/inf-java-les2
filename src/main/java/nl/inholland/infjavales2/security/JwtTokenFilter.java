package nl.inholland.infjavales2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = tokenProvider.resolveToken(httpServletRequest);

        try {
            if (token != null && tokenProvider.validateToken(token)) {

                Authentication authentication = tokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        } catch(ResponseStatusException ex) {
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(ex.getRawStatusCode(), ex.getMessage());
            return;
        }


        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
