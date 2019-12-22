package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import nc.Medas.service.LoginModel;
import nc.Medas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserRepo repository;

    @Autowired
    UserService detailsService;

    @RequestMapping("/login")
    @PostMapping
    public User authorize(@RequestBody LoginModel creds) {
        UserDetails userDetails = detailsService.loadUserByUsername(creds.getUsername());

        if(userDetails != null){
            if(userDetails.getPassword().equals(creds.getPassword())) {
                User user = repository.findByLogin(creds.getUsername());
                return user;
            }
        }

        return null;
    }



}
