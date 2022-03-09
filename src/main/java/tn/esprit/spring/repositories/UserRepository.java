package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entites.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
