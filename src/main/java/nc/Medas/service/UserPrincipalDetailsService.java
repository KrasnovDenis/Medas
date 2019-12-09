package nc.Medas.service;

import nc.Medas.model.User;
import nc.Medas.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepo userRepository;

    public UserPrincipalDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByLogin(s);
        if (user != null)
            return new UserPrincipal(user);
        else
            return null;

    }
}