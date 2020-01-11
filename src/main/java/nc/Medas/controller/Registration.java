package nc.Medas.controller;

import nc.Medas.exception.UserAlreadyExistException;
import nc.Medas.model.User;
import nc.Medas.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registration {
    
    private final UserService service;
    private final Logger LOG = LoggerFactory.getLogger(Registration.class);

    public Registration(UserService service) {

        this.service = service;
    }


    @PostMapping(value = "/registration")
    public User createUser(@RequestBody User user) {

        if(service.findByLogin(user.getLogin()) != null){
            LOG.error("Not unique login!");
            throw new UserAlreadyExistException("User with login " + user.getLogin() + " is already exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setPassword(encoder.encode(user.getPassword()));


        LOG.info("User has been registered " + user.getLogin());
        return service.save(user);
    }


}
