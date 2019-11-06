package nc.Medas.dao;

import nc.Medas.model.Film;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FilmDAO {

    public Film findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory(Film.class).openSession().get(Film.class, id);
    }

    public void save(Film film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(Film.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(film);
        tx1.commit();
        session.close();
    }

    public void update(Film film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(Film.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(film);
        tx1.commit();
        session.close();
    }

    public void delete(Film film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(Film.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(film);
        tx1.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Film> findAll() {
        return (List<Film>) HibernateSessionFactoryUtil
                .getSessionFactory(Film.class).openSession()
                .createQuery("from Film").list();

    }
}
