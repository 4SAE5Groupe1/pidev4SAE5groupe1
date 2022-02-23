package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.repositories.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements IServiceComplaint {

	@Autowired 
	ComplaintRepository complaintRepository ;
	
	
	@Override
	public void addComplaint(Complaint complaint) {
		complaintRepository.save(complaint);
		
	}
	
	public List<Complaint> getAllComplaints (){
		 return (List<Complaint>) complaintRepository.findAll();
		 }

	public void deleteComplaint(Long idComplaint){
		complaintRepository.deleteById(idComplaint);
	}

	@Override
	public Complaint updateComplaint(Complaint complaint) {
		return complaintRepository.save(complaint);
	}
}
