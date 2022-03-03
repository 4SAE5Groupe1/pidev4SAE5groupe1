package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Advertising;
import tn.esprit.spring.entites.Rating;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.RatingRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class RatingServiceImpl implements IRatingService{
	
	@Autowired
	RatingRepository RatingRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Rating> retrieveAllRatings() {
		List<Rating> Ratings =(List<Rating>)RatingRepository.findAll();
		for(Rating Rating:Ratings){
			log.info("Rating:"+Rating);
		}
		
		return Ratings;
	}

	@Override
	public Rating addRating(Rating Rating) {
		return RatingRepository.save(Rating);
	}

	@Override
	public Rating updateRating(Rating a) {
		// TODO Auto-generated method stub
		return RatingRepository.save(a);
	}

	@Override
	public Rating retrieveRating(Long idRating) {
		// TODO Auto-generated method stub
		Rating Rating = RatingRepository.findById(idRating).orElse(null);
		return Rating;
	}

	

}
