package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Offer;

public interface IServiceOffer {
	
public void addOffer(Offer offer);
	
	public List<Offer> getAllOffers ();

	public void deleteOffer(Long idOffer);
	
	public Offer updateOffer(Offer offer);
	
	public List<Offer> FilterDomain(String domainOffer);
	
	public  Offer   IncreaseLike(Long idOffer ,String nomUser );
	
	public  Offer DecreaseLike(Long idOffer, String nomUser);

}
