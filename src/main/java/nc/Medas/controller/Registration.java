package nc.Medas.controller;

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
            LOG.error("Дублирование логинов!");
            return new User();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setPassword(encoder.encode(user.getPassword()));


        LOG.info("зарегистрирован пользователь " + user.getLogin());
        return service.save(user);
    }


}
