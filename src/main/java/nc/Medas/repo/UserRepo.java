package nc.Medas.repo;

import nc.Medas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
    User findByLogin(String login);

}
