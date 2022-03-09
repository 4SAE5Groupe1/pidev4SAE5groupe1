package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long>{
	@Query("SELECT o FROM Offer o WHERE o.domain like %?1%")
	public List<Offer> FilterByDomain(String domainOffer);
	
	@Query("SELECT sum(o.like) FROM Offer o WHERE o.id =?1")
	public int getSumLikeOffer(Long idOffer);
}
