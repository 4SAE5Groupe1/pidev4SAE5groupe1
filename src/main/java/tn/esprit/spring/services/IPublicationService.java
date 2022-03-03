package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Publication;



public interface IPublicationService {
	
	List<Publication> retrieveAllPublications();
	Publication addPublication(Publication publication);
	void deletePublicationById(Long idPublication);
	public Publication retrievePublication(Long idPublication);
}
