package tn.esprit.spring.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Establishment;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Integer>{
	@Query("SELECT e FROM Establishment e WHERE e.Name =:name ") 
	List<Establishment> FiltrerEstablishmentByName(@Param("name") String name);
	
	@Query("SELECT e FROM Establishment e WHERE e.domain =:domain ") 
	List<Establishment> FiltrerEstablishmentBydomain(@Param("domain") String domain);
	
	@Query("SELECT e FROM Establishment e WHERE e.address =:address ") 
	List<Establishment> FiltrerEstablishmentByaddress(@Param("address") String address);

}
