package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Training;

public interface Itraining {

	List <Training> retriveAllTrainings();
	
	Training AddTraining(Training t) ;
	
	Training UpdateTraining(Training t);
	
	Training retriveTraining(int t);
	
	void DeleteTraining(int t);


	public void ajouterEtaffecterTrainingToTrainer(List<Training> lt, int iduser);
	
	public void affecterTrainingToTrainer(Training training, int iduser);
}
