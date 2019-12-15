package nc.Medas.controller;

import nc.Medas.config.HashAlgorithm;
import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import nc.Medas.ModelDetails.LoginModel;
import nc.Medas.service.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserRepo repository;

    @Autowired
    UserPrincipalDetailsService detailsService;

    @RequestMapping("/login")
    @PostMapping
    public User authorize(@RequestBody LoginModel creds) {
        UserDetails userDetails = detailsService.loadUserByUsername(creds.getUsername());

        if(userDetails != null){
            if(userDetails.getPassword().equals(HashAlgorithm.hash(creds.getPassword()))) {
                User user = repository.findByLogin(creds.getUsername());
                return user;
            }
        }

        return null;
    }



}
