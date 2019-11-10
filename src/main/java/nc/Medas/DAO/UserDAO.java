package nc.Medas.dao;

import nc.Medas.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDAO {
    /*
    private EntityManager em;

    public UserDAO() {
        em = getEntityManager();
    }
    public User findById(int id) {
        //EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.detach(user);
        return user;
    }

    @Transactional
    public void save(User user) {
        //EntityManager em = getEntityManager();
        em.persist(user);
    }

    @Transactional
    public void update(User user) {
       // EntityManager em = getEntityManager();
        em.remove(user);

    }

    @Transactional
    public void delete(User user) {
        //EntityManager em = getEntityManager();
        em.persist(user);

    }


    @SuppressWarnings("unchecked")
    public List<User> findAll() {

       // EntityManager em = getEntityManager();
        List<User> users = (List<User>) em.createQuery("from User").getResultList();
        return users;

    }

     */
}
