package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Emoji;
import tn.esprit.spring.entites.EmojiCount;
import tn.esprit.spring.entites.ForbiddenWord;
import tn.esprit.spring.entites.Publication;
import tn.esprit.spring.entites.PublicationCategory;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.EmojiRepository;
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
	EmojiRepository emojiRepository;
	
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
			if (pub.getBody().equals(Publication.getBody())) {
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

	@Override
	public List<Publication> retrievePublicationsByCategory(PublicationCategory pubCategory) {
		// check if publicationCategory already exist
		
		//
			List<Publication> Publications =(List<Publication>)publicationRepository.findByPublicationCategory(pubCategory);
			return Publications;

	}

	@Override
	public List<Publication> retrievePublicationsByQteReaction() {
		/*
		List<Emoji> Emojis =(List<Emoji>)emojiRepository.findAll();
		List<Publication> Publications =(List<Publication>)publicationRepository.findAll();
		List<EmojiCount> EmojiCounts = new ArrayList<EmojiCount>();
		// Push for each pub object EmojiCount (publication,nb_emoji)
		for(Publication publication:Publications){
			EmojiCount ec = new EmojiCount(publication,publication.getEmojis().size());
			EmojiCounts.add(ec);
		}
		System.out.println("EmojiCounts = ");
		// tree for EmojiCounts
		EmojiCount temp;
			      for(int i = EmojiCounts.size()-1 ; i>=1 ; i--)
			      {
			              for(int j = 0 ; j<i ; j++)
			              if(EmojiCounts.get(j).getTotalEmoji() > EmojiCounts.get(j+1).getTotalEmoji())
			              {
			                      temp = EmojiCounts.get(j+1);
			                      EmojiCounts.get(j+1).setPublication(EmojiCounts.get(j).getPublication());
			                      EmojiCounts.get(j+1).setTotalEmoji(EmojiCounts.get(j).getTotalEmoji());
			                      EmojiCounts.get(j).setPublication(temp.getPublication());    
			                      EmojiCounts.get(j+1).setTotalEmoji(temp.getTotalEmoji());
			              }
			      }
		// create sorted list of publication
			      List<Publication> sorted = new ArrayList<Publication>();
			      for(EmojiCount ec:EmojiCounts){
			    	  sorted.add(ec.getPublication());
			      }
			      
		
		return sorted;
		
	} */
	return null;

}
	
}
