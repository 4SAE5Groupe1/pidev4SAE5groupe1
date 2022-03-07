package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entites.ResponseLearner;

public interface IResponse {

	List <ResponseLearner> retriveAllResponseLearners();
	
	ResponseLearner AddResponseLearner(ResponseLearner r) ;
	
	ResponseLearner UpdateResponseLearner(ResponseLearner r);
	
	ResponseLearner retriveResponseLearner(int id);
	
	void DeleteResponseLearner(int id);
	
	public void ajouterEtaffecterResponseToQuestion(ResponseLearner r, int idQuestion) ;
}
