package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.ForbiddenWord;


public interface ForbiddenWordRepository extends CrudRepository<ForbiddenWord, Long> {

}
