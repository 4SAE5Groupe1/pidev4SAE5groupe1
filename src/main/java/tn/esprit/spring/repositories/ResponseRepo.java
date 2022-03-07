package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.ResponseLearner;

@Repository
public interface ResponseRepo extends JpaRepository<ResponseLearner, Integer>{

}
