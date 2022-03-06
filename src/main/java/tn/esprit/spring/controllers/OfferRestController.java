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

import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.services.IServiceOffer;

@RestController
public class OfferRestController {

	@Autowired
	IServiceOffer offerService;
	
	@PostMapping("/addOffer")
	@ResponseBody
	public void addOffer(@RequestBody Offer offer){
		offerService.addOffer(offer);
	}
	
	@GetMapping("/getOffers")
	@ResponseBody
	public List<Offer> getAllOffers (){
		 return offerService.getAllOffers();
		 }
	
	/* @DeleteMapping("/deleteOffer/{idOffer}")
	@ResponseBody
	
	public void removeOffer(@RequestBody Offer o) {
		
		offerService.deleteOffer(o.getIdOffer());
	} */
	
	@DeleteMapping("/deleteOffer")
	@ResponseBody
	
	public void removeOffer(@RequestBody Offer o) {
		
		offerService.deleteOffer(o.getIdOffer());
	} 
	
	@PutMapping("/modifyOffer/{idOffer}")
	@ResponseBody
	public Offer modifyComplaint(@RequestBody Offer o) {
	return offerService.updateOffer(o);
	}
	
	@GetMapping("/filterOffers")
	@ResponseBody
	public List<Offer> FilterOffersByDomain (String domainOffer){
		 domainOffer="TIC";
		 //domainOffer="Medical";
		 return offerService.FilterDomain(domainOffer);
		 }
	
	@PostMapping(value="/increaseLike/{idOffer}/{idUser}")
	@ResponseBody
	public  Boolean  IncreaseLike(@PathVariable("idOffer")Long idOffer,@PathVariable("idUser")Long idUser)
	{
	return 	offerService.IncreaseLike(idOffer, idUser);
	}

   @DeleteMapping(value="/decreaseLike/{idOffer}/{idUser}")
   @ResponseBody
   public  Boolean  DecreaseLike(@PathVariable("idOffer")Long idOffer,@PathVariable("idUser") Long idUser)
  {
	return offerService.DecreaseLike(idOffer, idUser);
  }

	
	
}
