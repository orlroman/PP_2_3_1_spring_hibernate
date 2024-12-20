package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void delete(int id);
    void update(int id, User user);
    List<User> getUsers();
    User getUser(int id);
    
}
