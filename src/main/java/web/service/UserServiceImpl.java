package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserDao userDao;
    
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
    
    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
    
    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
    
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
