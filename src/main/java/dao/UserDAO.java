package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);
    void deleteUserById(Long id);
    void editUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
