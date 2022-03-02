package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entites.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
