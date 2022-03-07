package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.Iuser;


@RestController
public class UserController {

	@Autowired
	Iuser UserService ;
	// http://localhost:8081/SpringMVC/GetUsers
	@GetMapping("/GetUsers") // convert objet java to json
	@ResponseBody
	public List<User> GetUsers() {
		List<User> list = (List<User>)UserService.GetUsers();
		return list;
	}
	
	// http://localhost:8081/SpringMVC/retrieve-User/
	@GetMapping("/retrieve-User/{User-id}")
	@ResponseBody
	public User retrieveQuiz(@PathVariable("User-id") int UserId) {
		return UserService.GetUser(UserId);
	}
	
	// http://localhost:8081/SpringMVC/addUser/
	@PostMapping("/addUser") // convert json to java object
	@ResponseBody
	public User addUser(@RequestBody User u) {
		User user = UserService.addUser(u);
		return  user;	
	}
}
