package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Candidacy;



public interface ICandidacy {
	List<Candidacy> retriveAllCandidacys();
	Candidacy addCandidacy (Candidacy c);
	void deleteCandidacy(int id);
	Candidacy updateCandidacy(Candidacy c);
	Candidacy retriveCandidacy(int id);
}
