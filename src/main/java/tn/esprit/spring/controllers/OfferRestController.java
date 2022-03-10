package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.Offer;
import tn.esprit.spring.services.IServiceOffer;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class OfferRestController {
	
	@Autowired
	IServiceOffer offerService;
	
	@PostMapping("/addOffer/{idUser}")
	@ResponseBody
	public void addOffer(@RequestBody Offer offer , @PathVariable("idUser") Long idUser){
		offerService.addOffer(offer,idUser);
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
		 //domainOffer="TIC";
		 domainOffer="Medical";
		 return offerService.FilterDomain(domainOffer);
		 }
	
	@PostMapping(value="/increaseLike/{idOffer}/{idUser}")
	@ResponseBody
	public  Boolean  IncreaseLike(@PathVariable("idOffer") Long idOffer,@PathVariable("idUser") Long idUser)
	{
	return 	offerService.IncreaseLike(idOffer, idUser);
	}

   @DeleteMapping(value="/decreaseLike/{idOffer}/{idUser}")
   @ResponseBody
   public  Boolean  DecreaseLike(@PathVariable("idOffer")Long idOffer,@PathVariable("idUser") Long idUser)
  {
	return offerService.DecreaseLike(idOffer, idUser);
  }
   
   @GetMapping(value="/getSumLikeOffer/{idOffer}")
   @ResponseBody
   public  int  getSumLikeOffer(@PathVariable("idOffer")Long idOffer)
  {
	return offerService.getNbLikeOffer(idOffer);
  }


}
