package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDAO{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        List<User> Users = (List<User>) userRepository.findAll();
        return Users;
    }

    @Override
    public User getUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
    /*@Autowired
    private UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user);
    }*/

}
