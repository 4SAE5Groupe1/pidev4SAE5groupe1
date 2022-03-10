package tn.esprit.spring.DAO;

import tn.esprit.spring.entites.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User updateUser(User user);
    public void deleteUser(Long userId);

    void deleteUser(Integer userId);

    public String forgotPassword(String email);
    public String resetPassword(String token, String password);
}
