package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public void editUserById(Long id, User user) {
        User editedUser = getUserById(id);
        editedUser.setName(user.getName());
        editedUser.setLastName(user.getLastName());
        editedUser.setAge(user.getAge());
        entityManager.refresh(editedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from users", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
