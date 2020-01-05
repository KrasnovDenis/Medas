package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {

        service.deleteById(id);
    }


}
