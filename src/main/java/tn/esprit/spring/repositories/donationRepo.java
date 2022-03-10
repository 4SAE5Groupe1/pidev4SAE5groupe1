package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entites.Donation;

import java.util.List;

public interface donationRepo extends JpaRepository<Donation,Integer> {
    @Query( value ="SELECT * FROM donation c  WHERE c.pot_idpot = ?1 ",nativeQuery = true)
    List<Donation> FinddonationByIdPot (Integer idpot);

}
