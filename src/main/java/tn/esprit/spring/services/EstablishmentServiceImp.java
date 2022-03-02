package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entites.Establishment;

import tn.esprit.spring.repositorys.EstablishmentRepository;

@Service
public class EstablishmentServiceImp implements IEstablishment{

	@Autowired
	EstablishmentRepository establishmentRepository;


	@Override
	public List<Establishment> retriveAllEstablishments() {
		// TODO Auto-generated method stub
		List<Establishment> establishments =(List<Establishment>) establishmentRepository.findAll();
		return establishments;
	}

	@Override
	public Establishment addEstablishment(Establishment c) {
		// TODO Auto-generated method stub
		
		return establishmentRepository.save(c);
	} 

	@Override
	public void deleteEstablishment(int id) {
		// TODO Auto-generated method stub
		this.establishmentRepository.deleteById(id);
	}

	@Override
	public Establishment updateEstablishment(Establishment c) {
		// TODO Auto-generated method stub
		return establishmentRepository.save(c);
	}

	@Override
	public Establishment retriveEstablishment(int id) {
		// TODO Auto-generated method stub
		Establishment establishment = establishmentRepository.findById(id).orElse(null);
		return establishment;
	}
	
	@Override
	public void NotifyCandidacyBySMS() {
	    

	}
}
