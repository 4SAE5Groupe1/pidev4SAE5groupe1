package tn.esprit.spring.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Training;


@Repository
public interface TrainingRepo extends JpaRepository<Training, Integer> {

	@Query("SELECT T FROM Training T WHERE T.startDate =:d ") 
	List<Training> FiltrerTrainingBystartDate( @Param("d") Date d);
	
	@Query("SELECT T FROM Training T WHERE T.domain =:d ") 
	List<Training> FiltrerTrainingBydomain( @Param("d") String d);
}
