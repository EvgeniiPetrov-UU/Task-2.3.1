package service;

import model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void deleteUserById(Long id);
    void editUserById(User user, Long id);
    List<User> getAllUsers();
    User getUserById(Long id);
}
