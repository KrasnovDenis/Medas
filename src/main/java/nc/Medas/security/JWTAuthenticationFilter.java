package nc.Medas.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import nc.Medas.model.LoginModel;
import nc.Medas.model.User;
import nc.Medas.service.UserPrincipal;
import net.minidev.json.parser.JSONParser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager manager;

    public JWTAuthenticationFilter(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginModel credentionals = null;
        try {
            credentionals = new ObjectMapper().readValue(request.getInputStream(), LoginModel.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        assert credentionals != null;

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                credentionals.getUsername(),
                credentionals.getPassword(),
                new ArrayList<>());



        return  manager.authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(userPrincipal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JWTProperties.TIME))
                .sign(Algorithm.HMAC512(JWTProperties.SECRET.getBytes()));

        response.addHeader(JWTProperties.HEADER_STRING, JWTProperties.TOKEN_PREFIX + token);

        try{
            User userToResponse = new User(userPrincipal.getUser());
            userToResponse.setLogin("");
            userToResponse.setPassword("");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(userToResponse));
        }
        catch (Exception e){
            System.out.println("Exception to give response user");
        }

    }
}
