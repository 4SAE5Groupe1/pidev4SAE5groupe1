package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Advertising;



public interface IAdvertisingService {
	
	List<Advertising> retrieveAllAdvertisings();
	Advertising addAdvertising(Advertising advertising);
	Advertising updateAdvertising(Advertising a);
	void deleteAdvertisingById(Long idAdvertising);
	public Advertising retrieveAdvertising(Long idAdvertising);
	Advertising changeAdvertisingStatus(Long idAdvertising,String status);
}
