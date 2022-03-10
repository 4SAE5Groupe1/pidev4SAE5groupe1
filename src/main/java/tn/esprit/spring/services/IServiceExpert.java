package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Expert;

public interface IServiceExpert {
	
public void addExpert(Expert expert);
	
	public List<Expert> getAllExperts ();

}
