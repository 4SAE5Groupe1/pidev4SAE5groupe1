package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.repositories.OfferRepository;

@Service
public class OfferServiceImpl implements IServiceOffer {

	@Autowired
	OfferRepository offerRepository;
	
	
	@Override
	public void addOffer(Offer offer) {
	   offerRepository.save(offer);	
	}

	@Override
	public List<Offer> getAllOffers() {
		return (List<Offer>) offerRepository.findAll();
	}

	@Override
	public void deleteOffer(Long idOffer) {
		offerRepository.deleteById(idOffer);
		
	}

	@Override
	public Offer updateOffer(Offer offer) {
		return offerRepository.save(offer);
	}
	
	@Override
	public List<Offer> FilterDomain(String domainOffer){
		
		if(domainOffer != null) {
			return offerRepository.FilterByDomain(domainOffer);
		}
		return (List<Offer>) offerRepository.findAll();
	}
	
	@Override
	public  Offer   IncreaseLike(Long idOffer ,String nomUser ) {
		//// TODO Auto-generated method stub
	
		Offer offer= offerRepository.findById(idOffer).orElse(null);
		offer.getLikesUsers().add(nomUser);
		offer.setLike(offer.getLike()+1);
		return offerRepository.save(offer);
		
		/* comment.getLikesPersons().add(id);
		comment.setLike(comment.getLike()+1);
		return comm.save(comment); */
	}
	
	@Override
	public  Offer DecreaseLike(Long idOffer, String nomUser) {
		// TODO Auto-generated method stub
		Offer offer= offerRepository.findById(idOffer).orElse(null);
	
		offer.getLikesUsers().remove(nomUser);
		offer.setLike(offer.getLike()-1);
		return offerRepository.save(offer);
	}
	
	

}
