package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{

}
