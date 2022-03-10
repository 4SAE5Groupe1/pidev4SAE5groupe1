package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.ChildComment;
import tn.esprit.spring.entites.ForbiddenWord;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.ChildCommentRepository;
import tn.esprit.spring.repositories.ForbiddenWordRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class ChildCommentServiceImpl implements IChildCommentService{
	
	@Autowired
	ChildCommentRepository ChildCommentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ForbiddenWordRepository forbiddenWordRepository;

	@Override
	public List<ChildComment> retrieveAllChildComments() {
		List<ChildComment> ChildComments =(List<ChildComment>)ChildCommentRepository.findAll();
		for(ChildComment ChildComment:ChildComments){
			log.info("ChildComment:"+ChildComment);
		}
		
		return ChildComments;
	}

	@Override
	public ChildComment addChildComment(ChildComment ChildComment) {
		
		// Dictionnaire de mots interdits
		List<ForbiddenWord> ForbiddenWords =(List<ForbiddenWord>)forbiddenWordRepository.findAll();
		for(ForbiddenWord forbiddenWord:ForbiddenWords){
			if (ChildComment.getBody().contains(forbiddenWord.getWord())) {
				System.out.println(forbiddenWord+" => FOUND !");
				return null;
			}
				
		}
		return ChildCommentRepository.save(ChildComment);
	}

	@Override
	public ChildComment updateChildComment(ChildComment a) {
		// TODO Auto-generated method stub
		return ChildCommentRepository.save(a);
	}

	@Override
	public void deleteChildCommentById(Long idChildComment) {
		 ChildCommentRepository.deleteById(idChildComment);
	}

	@Override
	public ChildComment retrieveChildComment(Long idChildComment) {
		// TODO Auto-generated method stub
		ChildComment ChildComment = ChildCommentRepository.findById(idChildComment).orElse(null);
		return ChildComment;
	}


	
	
	
	

}
