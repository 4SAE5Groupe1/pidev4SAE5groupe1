package tn.esprit.spring.repositorys;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.entites.Nationality;



@Repository
public interface CandidacyRepository extends JpaRepository<Candidacy, Integer>{
	@Query("SELECT count(*) FROM Candidacy c WHERE c.nationality =:nat AND c.date =:d ") 
	int FiltrerCandidacyByDateAndNationality(@Param("nat") Nationality nat, @Param("d") Date d);

}
