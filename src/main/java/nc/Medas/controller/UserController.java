package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRepo repository;

    @Autowired
    UserController(UserRepo repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> list() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user) {
        return user;
    }


    @PostMapping
    public User createUser(@RequestBody User user) {

        return repository.save(user);
    }

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User messageFromDb,
            @RequestBody User message
    ) {
        BeanUtils.copyProperties(message, messageFromDb, "id");

        return repository.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User message) {

        repository.delete(message);
    }


}
