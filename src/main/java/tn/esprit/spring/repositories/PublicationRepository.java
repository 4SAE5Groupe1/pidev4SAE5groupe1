package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.Publication;


public interface PublicationRepository extends CrudRepository<Publication, Long> {

}
