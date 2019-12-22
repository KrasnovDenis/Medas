package nc.Medas.service;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRepo userRepo;
    private UserDetails userDetails;

    UserService( UserRepo userRepo,UserDetails userDetails) {
        this.userRepo = userRepo;
        this.userDetails = userDetails;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    public List<User> getAllUsers(int id) {
        return userRepo.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String login) {
        return new UserPrincipal(userRepo.findByLogin(login));
    }

}
