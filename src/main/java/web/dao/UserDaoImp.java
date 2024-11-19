package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
    
    @Override
    public void update(int id, User user) {
        User updateUser = entityManager.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setAge(user.getAge());
        
        entityManager.merge(updateUser);
    }
    
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
    
    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
