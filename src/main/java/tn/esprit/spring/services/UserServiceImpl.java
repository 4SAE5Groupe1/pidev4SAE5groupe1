package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository UserRepository;

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users =(List<User>)UserRepository.findAll();
		for(User User:users){
			log.info("User:"+User);
		}
		
		return users;
	}

	@Override
	public User addUser(User u) {
		return UserRepository.save(u);
	}

	@Override
	public User updateUser(User a) {
		// TODO Auto-generated method stub
		return UserRepository.save(a);
	}

	@Override
	public void deleteUserById(Long idUser) {
		 UserRepository.deleteById(idUser);
	}

	@Override
	public User retrieveUserById(Long idUser) {
		// TODO Auto-generated method stub
		User User = UserRepository.findById(idUser).orElse(null);
		return User;
	}

	
	
	

}
