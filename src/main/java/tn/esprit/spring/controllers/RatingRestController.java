package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.Rating;
import tn.esprit.spring.services.IRatingService;

@RestController
public class RatingRestController {
	

	@Autowired
	IRatingService RatingService; // interface
	
	@GetMapping("/retrieveAllRatings")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllRatings
	public List<Rating> getRatings(){
		List<Rating> list =  RatingService.retrieveAllRatings();
		return list;
	}
	

	@GetMapping("/retrieveRating/{Rating-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveRating/{Rating-id}
	public Rating retrieveRating(@PathVariable("Rating-id") Long RatingId){
		Rating c =  RatingService.retrieveRating(RatingId);
		return c;
	}
	
	
	@PostMapping("/addRating")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addRating
	public Rating addRating (@RequestBody Rating newRating) {
		return RatingService.addRating(newRating);
		
	}
	
	//http://localhost:8089/SpringMVC/modifyRating
	@PutMapping("/modifyRating")
	@ResponseBody
	public Rating modifyRating (@RequestBody Rating Rating) {
		return RatingService.updateRating(Rating);
		
	}
	
}
