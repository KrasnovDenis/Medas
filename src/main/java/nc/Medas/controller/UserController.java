package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserRepo service;

    @Autowired
    UserController(UserRepo service) {
        this.service = service;
    }

    @GetMapping
    public List<User> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public User getOne(@PathVariable("id") User user) {
        return user;
    }


    @PostMapping
    public void createUser(User user) {
        service.save(user);
    }

    @PutMapping("{id}")
    public User update(
            @PathVariable("id") User messageFromDb,
            @RequestBody User message
    ) {
        BeanUtils.copyProperties(message, messageFromDb, "id");

        return service.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") User message) {

        service.delete(message);
    }


}
