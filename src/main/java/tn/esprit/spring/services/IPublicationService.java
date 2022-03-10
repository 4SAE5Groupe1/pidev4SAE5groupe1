package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.entites.PublicationCategory;



public interface IPublicationService {
	
	List<Publication> retrieveAllPublications();
	Publication addPublication(Publication publication);
	void deletePublicationById(Long idPublication);
	public Publication retrievePublication(Long idPublication);
	List<Publication> retrievePublicationsByCategory(PublicationCategory pubCategory);
	List<Publication> retrievePublicationsByQteReaction();
}
