package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
