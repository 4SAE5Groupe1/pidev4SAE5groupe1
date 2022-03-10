package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.Rating;


public interface RatingRepository extends CrudRepository<Rating, Long> {

}
