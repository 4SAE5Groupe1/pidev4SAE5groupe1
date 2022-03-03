package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Rating;



public interface IRatingService {
	
	List<Rating> retrieveAllRatings();
	Rating addRating(Rating Rating);
	Rating updateRating(Rating a);
	public Rating retrieveRating(Long idRating);
}
