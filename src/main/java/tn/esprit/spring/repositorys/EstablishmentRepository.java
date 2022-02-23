package tn.esprit.spring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Establishment;


@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Integer>{

}
