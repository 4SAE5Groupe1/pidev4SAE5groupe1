package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
