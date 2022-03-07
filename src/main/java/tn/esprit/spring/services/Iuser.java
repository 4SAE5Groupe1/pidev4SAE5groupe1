package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.User;

public interface Iuser {
	List<User> GetUsers() ;
	
	User GetUser(int id) ;
	
	User addUser(User u) ;
	
	User UpdateUser (User u);
	
	void DeleteUser(int id) ;

}
