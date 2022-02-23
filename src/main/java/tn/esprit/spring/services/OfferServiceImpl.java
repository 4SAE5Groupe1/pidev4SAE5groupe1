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

}
