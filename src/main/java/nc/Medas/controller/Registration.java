package nc.Medas.controller;

import nc.Medas.model.Film;
import nc.Medas.model.User;
import nc.Medas.repo.FilmRepo;
import nc.Medas.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class Registration {
    private final UserRepo repository;

    @Autowired
    Registration(UserRepo repository) {
        this.repository = repository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
       return repository.save(user);
    }

    @GetMapping
    public String createUser() {
        return "GET? WTF?!";
    }


}
