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

import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.services.IPublicationService;

@RestController
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
