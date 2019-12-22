package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/registration")
public class Registration {
    private final UserRepo repository;


    Registration(UserRepo repository) {

        this.repository = repository;
    }


    @PostMapping
    public User createUser(@RequestBody User user)throws NoSuchAlgorithmException {

        String hash = String.valueOf(new BigInteger(1,
                MessageDigest.getInstance("SHA-512")
                        .digest(user.getPassword().getBytes()))
        );

        user.setPassword(hash);

        return repository.save(user);
    }

    @GetMapping
    public String createUser() {
        return "GET? WTF?!";
    }


}
