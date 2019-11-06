package  nc.Medas.service;

import nc.Medas.model.User;
import org.springframework.stereotype.Service;
import  nc.Medas.dao.UserDAO;


import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO = new UserDAO();


    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public User findUserById(int id) {
        return userDAO.findById(id);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

}
