package tn.esprit.spring.services;

import tn.esprit.spring.entites.Rating;

import java.util.List;



public interface IRatingService {
	
	List<Rating> retrieveAllRatings();
	Rating addRating(Rating Rating);
	Rating updateRating(Rating a);
	public Rating retrieveRating(Long idRating);
}
