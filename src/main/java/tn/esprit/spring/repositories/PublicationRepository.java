package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.EmojiCount;
import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.entites.PublicationCategory;


@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {
	
    @Query("SELECT p from Publication p where p.publicationCategory =:pubCategory ") 
	List<Publication> findByPublicationCategory(@Param("pubCategory") PublicationCategory pubCategory); 
      
    

}
