package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void editUserById(User user, Long id) {
        entityManager.refresh(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT n FROM User n", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
