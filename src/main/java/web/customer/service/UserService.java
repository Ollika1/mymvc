package web.customer.service;

import web.customer.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    void delete(int id);
    void edit(int id, User user);
    User getById(int id);
}
