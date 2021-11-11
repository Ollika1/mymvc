package web.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.customer.dao.UserDaoImp;
import web.customer.model.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDaoImp userDaoImp;
    public UserServiceImp() {
    }

    @Autowired
    public void setUserDaoImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }
    @Transactional
    @Override
    public void save(User user) {
        userDaoImp.save(user);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDaoImp.delete(id);
    }
    @Transactional
    @Override
    public void edit(int id, User user) {
        userDaoImp.edit(id, user);
    }
    @Transactional
    @Override
    public User getById(int id) {
        return userDaoImp.getById(id);
    }
}
