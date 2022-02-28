package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Offer;

public interface IServiceComplaint {

	public void addComplaint(Complaint complaint , Long idUser);
	
	public List<Complaint> getAllComplaints ();

	public void deleteComplaint(Long idComplaint);
	
	public Complaint updateComplaint(Complaint complaint);
	
	public List<Complaint> FilterDecision(String decisionComplaint);
}
