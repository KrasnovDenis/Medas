package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.service.LoginModel;
import nc.Medas.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {



    private final UserService userService;
    private final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public User authorize(@RequestBody LoginModel creds) {
        UserDetails userDetails = userService
                .loadUserByUsername(creds.getUsername());

        if(userDetails != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if(encoder.matches(creds.getPassword(),userDetails.getPassword() )) {
                LOG.info("Пользователь " +creds.getUsername() + " зашел в систему"  );
                return userService.findByLogin(creds.getUsername());

            }
            else{
                LOG.info("неправильный пароль"  );
            }
        }
        else{
            LOG.info("Пользователь " +creds.getUsername() + " не найден"  );
        }
        return new User();
    }



}
