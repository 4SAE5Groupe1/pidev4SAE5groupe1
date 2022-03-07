package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.UserRepo;
@Service
public class ImpUser implements Iuser {

	@Autowired
	UserRepo userRepo ;
	@Override
	public List<User> GetUsers() {
		// TODO Auto-generated method stub
		List<User> list = userRepo.findAll();
		return list;
	}

	@Override
	public User GetUser(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElse(null);
		return user;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		User user = userRepo.save(u);
		return user ;
	}

	@Override
	public User UpdateUser(User u) {
		// TODO Auto-generated method stub
		return userRepo.save(u);
		
	}

	@Override
	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}

}
