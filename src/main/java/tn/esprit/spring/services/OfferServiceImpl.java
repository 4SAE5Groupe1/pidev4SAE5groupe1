package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.OfferRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class OfferServiceImpl implements IServiceOffer {

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
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
	public  Boolean   IncreaseLike(Long idOffer ,Long idUser ) {
		//// TODO Auto-generated method stub
	
		 
		User user = userRepository.findById(idUser).orElse(null)  ;
		Offer offer= offerRepository.findById(idOffer).orElse(null);
		
		if(offer.getLikesUsers().contains(idUser))
		{
			return false ;
		}
		else
		{
		
            offer.getLikesUsers().add(idUser);
			
			offer.setLike(offer.getLike()+1);
			offerRepository.save(offer); 
			
			return true ;
			
			
		}
			
		
		
		/*offer.getLikesUsers().add(user.getNom());
		offer.setLike(offer.getLike()+1);
		/*return offerRepository.save(offer);
		return true ;*/
		
		/* comment.getLikesPersons().add(id);
		comment.setLike(comment.getLike()+1);
		return comm.save(comment); */
	}
	
	@Override
	public  Boolean   DecreaseLike(Long idOffer ,Long idUser ) {
		//// TODO Auto-generated method stub
	
		
		User user = userRepository.findById(idUser).orElse(null);
		Offer offer= offerRepository.findById(idOffer).orElse(null);
		
		if(offer.getLikesUsers().contains(idUser))
		{
			offer.getLikesUsers().remove(idUser);
			offer.setLike(offer.getLike()-1);
			offerRepository.save(offer);
			return true ;
		}
		
		else 
			
			return false ;
	}
	
	

}
