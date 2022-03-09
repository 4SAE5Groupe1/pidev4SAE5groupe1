package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.Expert;
import tn.esprit.spring.repositories.ExpertRepository;

@Service
public class ExpertServiceImpl implements IServiceExpert {

	@Autowired
	ExpertRepository expertRepository;
	
	@Override
	public void addExpert(Expert expert) {
		expertRepository.save(expert);
		
	}

	@Override
	public List<Expert> getAllExperts() {
		return (List<Expert>) expertRepository.findAll();
	}
	
}
