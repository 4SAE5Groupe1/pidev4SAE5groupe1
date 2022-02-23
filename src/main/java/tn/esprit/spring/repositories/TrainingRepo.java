package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Training;


@Repository
public interface TrainingRepo extends JpaRepository<Training, Integer> {

}
