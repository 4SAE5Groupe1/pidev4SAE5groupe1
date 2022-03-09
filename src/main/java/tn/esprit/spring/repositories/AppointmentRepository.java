package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	@Query("select t from Appointment as t ")
	public List<Appointment> getAllApp();

}
