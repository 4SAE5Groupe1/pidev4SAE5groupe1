package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.UserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // http://localhost:8089/SpringMVC/servlet/getAllUsers
    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> userList = (List<User>) userService.getAllUsers();
        return userList;
    }

    // http://localhost:8089/SpringMVC/servlet/addUser
    @PostMapping("/addUser")
    @ResponseBody
    public User addUser(@RequestBody User u){
        User User = userService.addUser(u);
        return User;
    }

    // http://localhost:8089/SpringMVC/servlet/getUser
    @GetMapping("/getUser/{UserId}")
    @ResponseBody
    public User getUser(@PathVariable("UserId") int userId){
        User user = userService.getUser(userId);
        return user;
    }

    // http://localhost:8089/SpringMVC/servlet/updateUser
    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    // http://localhost:8089/SpringMVC/servlet/deleteUser
    @DeleteMapping("/deleteUser/{userId}")
    @ResponseBody
    public void deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
    }
}
