package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.entites.PublicationCategory;
import tn.esprit.spring.services.IPublicationService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class PublicationRestController {
	

	@Autowired
	IPublicationService publicationService; // interface
	
	@GetMapping("/retrieveAllPublications")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllPublications
	public List<Publication> getPublications(){
		List<Publication> list =  publicationService.retrieveAllPublications();
		return list;
	}
	
	@GetMapping("/retrievePublicationsByQteReaction")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrievePublicationsByQteReaction
	public List<Publication> retrievePublicationsByQteReaction(){
		List<Publication> list =  publicationService.retrievePublicationsByQteReaction();
		return list;
	}
	
	
	@GetMapping("/retrievePublicationsByCategory/{pubCategory}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrievePublicationsByCategory/{pubCategory}
	public List<Publication> getPublicationsByCategory(@PathVariable("pubCategory") PublicationCategory pubCategory){
		List<Publication> list =  publicationService.retrievePublicationsByCategory(pubCategory);
		return list;
	}

	@GetMapping("/retrievePublication/{publication-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrievePublication/{publication-id}
	public Publication retrievePublication(@PathVariable("publication-id") Long publicationId){
		Publication c =  publicationService.retrievePublication(publicationId);
		return c;
	}
	
	
	@PostMapping("/addPublication")
	@ResponseBody
	//http://localhost:8089/SpringMVC/addPublication
	public Publication addPublication (@RequestBody Publication newPublication) {
		return publicationService.addPublication(newPublication);
		
	}
	
	
	//http://localhost:8089/SpringMVC/deletePublication/{publication-id}
	@DeleteMapping("/deletePublication/{publication-id}")
	@ResponseBody
	public void deletePublication (@PathVariable("publication-id") Long publicationId) {
		publicationService.deletePublicationById(publicationId);
	}
	
	
	
}
