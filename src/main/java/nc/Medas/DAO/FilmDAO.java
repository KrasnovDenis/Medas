package nc.Medas.dao;

import nc.Medas.model.Film;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FilmDAO {
    /*
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("beans");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private EntityManager em;

    public FilmDAO() {
        em = getEntityManager();
    }

    public Film findById(int id) {
        return em.find(Film.class,new Integer(id));

    }

    @Transactional
    public void save(Film film) {
        //EntityManager em = getEntityManager();
        em.persist(film);
    }

    @Transactional
    public void update(Film film) {
        // EntityManager em = getEntityManager();
        em.remove(film);

    }

    @Transactional
    public void delete(Film film) {
        //EntityManager em = getEntityManager();
        em.persist(film);

    }


    @SuppressWarnings("unchecked")
    public List<Film> findAll() {
        return (List<Film>) em.createQuery("from Film").getResultList();
    }
    *
     */
}
