package nc.Medas.controller;

import nc.Medas.model.User;
import nc.Medas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService = new UserService();


    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable String id) {
        return userService.findUserById(Integer.parseInt(id));
    }

    @PostMapping
    public void createUser(User user) {
         userService.save(user);
    }

    @PatchMapping("{id}")
    public void updateUser(@PathVariable String id) {
        userService.update(userService.findUserById(Integer.parseInt(id)));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(userService.findUserById(Integer.parseInt(id)));
    }
}
