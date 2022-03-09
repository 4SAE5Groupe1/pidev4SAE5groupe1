package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.entites.Nationality;
import tn.esprit.spring.entites.Status;;

@Repository
public interface CandidacyRepository extends JpaRepository<Candidacy, Integer> {
	@Query("SELECT count(*) FROM Candidacy c WHERE c.nationality =:nat AND c.date =:d ")
	int FiltrerCandidacyByDateAndNationality(@Param("nat") Nationality nat, @Param("d") Date d);

	@Query("SELECT c FROM Candidacy c WHERE c.status =:status ")
	List<Candidacy> FiltrerCandidacyByStatus(@Param("status") Status status);

}
