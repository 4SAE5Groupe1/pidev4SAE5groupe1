package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Advertising;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.AdvertisingRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class AdvertisingServiceImpl implements IAdvertisingService{
	
	@Autowired
	AdvertisingRepository advertisingRepository;
	UserRepository userRepository;

	@Override
	public List<Advertising> retrieveAllAdvertisings() {
		List<Advertising> advertisings =(List<Advertising>)advertisingRepository.findAll();
		for(Advertising advertising:advertisings){
			log.info("Advertising:"+advertising);
		}
		
		return advertisings;
	}

	@Override
	public Advertising addAdvertising(Advertising advertising) {
		return advertisingRepository.save(advertising);
	}

	@Override
	public Advertising updateAdvertising(Advertising a) {
		// TODO Auto-generated method stub
		return advertisingRepository.save(a);
	}

	@Override
	public void deleteAdvertisingById(Long idAdvertising) {
		 advertisingRepository.deleteById(idAdvertising);
	}

	@Override
	public Advertising retrieveAdvertising(Long idAdvertising) {
		// TODO Auto-generated method stub
		Advertising advertising = advertisingRepository.findById(idAdvertising).orElse(null);
		return advertising;
	}

	@Override
	public Advertising changeAdvertisingStatus(Long idAdvertising, String status) {
		Advertising advertising = advertisingRepository.findById(idAdvertising).orElse(null);
		advertising.setAdvStatus(status);
		return advertisingRepository.save(advertising);
		
	}


	
	
	
	

}
