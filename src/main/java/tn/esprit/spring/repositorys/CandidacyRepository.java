package tn.esprit.spring.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.Candidacy;


@Repository
public interface CandidacyRepository extends JpaRepository<Candidacy, Integer>{

}
