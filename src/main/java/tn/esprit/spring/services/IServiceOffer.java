package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Offer;

public interface IServiceOffer {
	
public void addOffer(Offer offer ,  Long idUser);
	
	public List<Offer> getAllOffers ();

	public void deleteOffer(Long idOffer );
	
	public Offer updateOffer(Offer offer);
	
	public List<Offer> FilterDomain(String domainOffer);
	
	public  Boolean   IncreaseLike(Long idOffer ,Long idUser );
	
	public  Boolean   DecreaseLike(Long idOffer ,Long idUser );
	
	public int getNbLikeOffer(Long idOffer);

}
