package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
