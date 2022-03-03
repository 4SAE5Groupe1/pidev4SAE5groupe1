package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.User;



public interface IUserService {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	User updateUser(User u);
	void deleteUserById(Long idUser);
	public User retrieveUserById(Long idUser);
}
