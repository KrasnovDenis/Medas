package nc.Medas.dao;

import nc.Medas.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return(List<User>) HibernateSessionFactoryUtil.getSessionFactory(User.class).openSession().createQuery("from User").list();
    }
}
