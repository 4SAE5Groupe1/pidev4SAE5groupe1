package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entites.Candidacy;
import tn.esprit.spring.entites.Establishment;
import tn.esprit.spring.entites.Status;
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
	
	@Override
	public List<Establishment> FiltrerEstablishmentByName(String name) {
		// TODO Auto-generated method stub
		return this.establishmentRepository.FiltrerEstablishmentByName(name);
	}
	
	@Override
	public List<Establishment> FiltrerEstablishmentBydomain(String domain) {
		// TODO Auto-generated method stub
		return this.establishmentRepository.FiltrerEstablishmentBydomain(domain);
	}
	
	@Override
	public List<Establishment> FiltrerEstablishmentByaddress(String address) {
		// TODO Auto-generated method stub
		return this.establishmentRepository.FiltrerEstablishmentByaddress(address);
	}
	
}
