package nc.Medas.repo;

import nc.Medas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Date;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
    User findByLogin(String login);

    @Transactional
    @Modifying
    @Query("update User u set u.money = ?2 where u.id = ?1")
    int setFixedMoneyFor(int id, double money);


    @Transactional
    @Modifying
    @Query("update User u set u.role = ?10 , u.email=?9,u.telephone=?8,u.login=?7,u.password=?6, u.money = ?5, u.birthDate = ?4, u.lastName = ?3, u.firstName = ?2 where u.id = ?1")
    void update(int id, String fistName, String lastName, Date birthDate, double money, String password, String login, String telephone, String email, String role);


}
