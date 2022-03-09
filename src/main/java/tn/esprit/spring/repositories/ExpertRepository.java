package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Expert;

@Repository
public interface ExpertRepository extends CrudRepository<Expert, Long>{

}
