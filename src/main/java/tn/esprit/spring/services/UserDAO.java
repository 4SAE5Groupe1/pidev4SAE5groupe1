package tn.esprit.spring.services;

import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUser(int userId);
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(int userId);
}
