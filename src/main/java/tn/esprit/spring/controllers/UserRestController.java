package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.IUserService;

@RestController
public class UserRestController {
	

	@Autowired
	IUserService userService; // interface
	
	@GetMapping("/retrieveAllUsers")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllUsers
	public List<User> getUsers(){
		List<User> list =  userService.retrieveAllUsers();
		return list;
	}
	

	@GetMapping("/retrieveUser/{User-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveUser/{User-id}
	public User retrieveUser(@PathVariable("User-id") Long UserId){
		User c =  userService.retrieveUserById(UserId);
		return c;
	}
	
	
	@PostMapping("/addUser")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addUser
	public User addUser (@RequestBody User newUser) {
		return userService.addUser(newUser);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyUser
	@PutMapping("/modifyUser")
	@ResponseBody
	public User modifyUser (@RequestBody User User) {
		return userService.updateUser(User);
		
	}
	
	//http://localhost:8089/SpringMVC/deleteUser/{User-id}
	@DeleteMapping("/deleteUser/{User-id}")
	@ResponseBody
	public void deleteUser (@PathVariable("User-id") Long UserId) {
		userService.deleteUserById(UserId);
	}
	
	
	
}
