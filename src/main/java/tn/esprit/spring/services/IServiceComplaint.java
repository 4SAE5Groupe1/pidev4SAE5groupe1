package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Complaint;

public interface IServiceComplaint {

	public void addComplaint(Complaint complaint);
	
	public List<Complaint> getAllComplaints ();

	public void deleteComplaint(Long idComplaint);
	
	public Complaint updateComplaint(Complaint complaint);
}
