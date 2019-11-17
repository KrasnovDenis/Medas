package nc.Medas.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import nc.Medas.service.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private UserRepo repository;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,  UserRepo repository) {
        super(authenticationManager);
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JWTProperties.HEADER_STRING);

        if(header == null || !header.startsWith(JWTProperties.TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return ;
        }

        Authentication auth = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(auth);

        chain.doFilter(request,response);

    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JWTProperties.HEADER_STRING)
                .replace(JWTProperties.TOKEN_PREFIX, "");

        if(token != null ) {
            String username = JWT.require(Algorithm.HMAC512(JWTProperties.SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            if(username != null ) {
                User user = repository.findByLogin(username);
                UserPrincipal principal = new UserPrincipal(user);
                UsernamePasswordAuthenticationToken auth =  new UsernamePasswordAuthenticationToken(username, null, principal.getAuthorities());
                return auth;
            }
        }
        return null;
    }
}
