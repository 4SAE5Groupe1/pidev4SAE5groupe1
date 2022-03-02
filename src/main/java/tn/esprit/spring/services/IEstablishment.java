package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Establishment;

public interface IEstablishment {
	List<Establishment> retriveAllEstablishments();
	Establishment addEstablishment (Establishment c);
	void deleteEstablishment(int id);
	Establishment updateEstablishment(Establishment c);
	Establishment retriveEstablishment(int id);
	void NotifyCandidacyBySMS();
	
}
