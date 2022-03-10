package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Complaint;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Long>{
	
	@Query("SELECT c FROM Complaint c WHERE c.decision like %?1%")
	public List<Complaint> FilterByDecision(String decisionComplaint);

}
