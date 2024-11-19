package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImp implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}
