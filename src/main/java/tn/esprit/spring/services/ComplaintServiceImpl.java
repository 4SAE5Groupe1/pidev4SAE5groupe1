package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.Complaint;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.ComplaintRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class ComplaintServiceImpl implements IServiceComplaint{

	@Autowired 
	ComplaintRepository complaintRepository ;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void addComplaint(Complaint complaint , Long idUser) {
		
		complaintRepository.save(complaint);
		
		User user = userRepository.findById(idUser).orElse(null);
		complaint.setUser(user);
		complaintRepository.save(complaint);
		
		//formation.setFormateur(formateur);
		
		//formationRepository.save(formation);
		
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

	@Override
	public List<Complaint> FilterDecision(String decisionComplaint) {
		
		if(decisionComplaint != null){
			return complaintRepository.FilterByDecision(decisionComplaint);
		}
		return (List<Complaint>) complaintRepository.findAll();
	}
}
