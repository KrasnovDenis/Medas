package nc.Medas.service;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void update(User user) {
        userRepo.update(user.getId(), user.getFirstName(),
                user.getLastName(), user.getBirthDate(),
                user.getMoney(), user.getPassword(),
                user.getLogin(), user.getTelephone(),
                user.getEmail(), user.getRole());
    }

    public Optional<User> findById(long id) {
        return userRepo.findById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userRepo.findByLogin(login);
        if(user == null){
            return null;
        }
        return new UserPrincipal(user);
    }

}
