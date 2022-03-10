package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Rating;
import tn.esprit.spring.services.IRatingService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
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
