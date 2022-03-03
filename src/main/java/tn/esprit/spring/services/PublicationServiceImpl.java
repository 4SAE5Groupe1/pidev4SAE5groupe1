package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.ForbiddenWord;
import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.ForbiddenWordRepository;
import tn.esprit.spring.repositories.PublicationRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class PublicationServiceImpl implements IPublicationService{
	
	@Autowired
	PublicationRepository publicationRepository;
	
	@Autowired
	ForbiddenWordRepository forbiddenWordRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Publication> retrieveAllPublications() {
		List<Publication> Publications =(List<Publication>)publicationRepository.findAll();
		for(Publication Publication:Publications){
			log.info("Publication:"+Publication);
		}
		
		return Publications;
	}

	@Override
	public Publication addPublication(Publication Publication) {
		// Dictionnaire de mots interdits
		List<ForbiddenWord> ForbiddenWords =(List<ForbiddenWord>)forbiddenWordRepository.findAll();
		for(ForbiddenWord forbiddenWord:ForbiddenWords){
			if (Publication.getBody().contains(forbiddenWord.getWord()) || Publication.getSubject().contains(forbiddenWord.getWord())) {
				System.out.println(forbiddenWord+" => FOUND !");
				return null;
			}
				
		}
		//Test sujets redondants
		List<Publication> Publications =(List<Publication>)publicationRepository.findAll();
		for(Publication pub:Publications){
			if (pub.getBody().equals(Publication.getBody()) || pub.getSubject().equals(Publication.getSubject())) {
				System.out.println( "duplicated subject detected !");
				return null;
			}
		}
		return publicationRepository.save(Publication);
	}

	@Override
	public void deletePublicationById(Long idPublication) {
		publicationRepository.deleteById(idPublication);
	}

	@Override
	public Publication retrievePublication(Long idPublication) {
		// TODO Auto-generated method stub
		Publication Publication = publicationRepository.findById(idPublication).orElse(null);
		return Publication;
	}
	

}
