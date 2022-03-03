package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.ForbiddenWord;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.ForbiddenWordRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class ForbiddenWordServiceImpl implements IForbiddenWordService{
	
	@Autowired
	ForbiddenWordRepository ForbiddenWordRepository;
	UserRepository userRepository;

	@Override
	public List<ForbiddenWord> retrieveAllForbiddenWords() {
		List<ForbiddenWord> ForbiddenWords =(List<ForbiddenWord>)ForbiddenWordRepository.findAll();
		for(ForbiddenWord ForbiddenWord:ForbiddenWords){
			log.info("ForbiddenWord:"+ForbiddenWord);
		}
		
		return ForbiddenWords;
	}

	@Override
	public ForbiddenWord addForbiddenWord(ForbiddenWord ForbiddenWord) {
		return ForbiddenWordRepository.save(ForbiddenWord);
	}

	@Override
	public ForbiddenWord updateForbiddenWord(ForbiddenWord a) {
		// TODO Auto-generated method stub
		return ForbiddenWordRepository.save(a);
	}

	@Override
	public void deleteForbiddenWordById(Long idForbiddenWord) {
		 ForbiddenWordRepository.deleteById(idForbiddenWord);
	}

	@Override
	public ForbiddenWord retrieveForbiddenWord(Long idForbiddenWord) {
		// TODO Auto-generated method stub
		ForbiddenWord ForbiddenWord = ForbiddenWordRepository.findById(idForbiddenWord).orElse(null);
		return ForbiddenWord;
	}

}
