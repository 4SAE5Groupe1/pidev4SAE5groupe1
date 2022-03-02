package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.entites.Nationality;



public interface ICandidacy {
	List<Candidacy> retriveAllCandidacys();
	Candidacy addCandidacy (Candidacy c);
	void deleteCandidacy(int id);
	Candidacy updateCandidacy(Candidacy c);
	Candidacy retriveCandidacy(int id);
	int FiltrerCandidacyByDateAndNationality(Nationality nat, Date d);
}
