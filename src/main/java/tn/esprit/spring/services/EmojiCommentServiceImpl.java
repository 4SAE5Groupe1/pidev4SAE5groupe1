package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Advertising;
import tn.esprit.spring.entites.EmojiComment;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.EmojiCommentRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class EmojiCommentServiceImpl implements IEmojiCommentService{
	
	@Autowired
	EmojiCommentRepository EmojiCommentRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<EmojiComment> retrieveAllEmojisComment() {
		List<EmojiComment> EmojiComments =(List<EmojiComment>)EmojiCommentRepository.findAll();
		for(EmojiComment EmojiComment:EmojiComments){
			log.info("EmojiComment:"+EmojiComment);
		}
		
		return EmojiComments;
	}

	@Override
	public EmojiComment addEmojiComment(EmojiComment EmojiComment) {
		
		List<EmojiComment> EmojiCommentsPrimary =(List<EmojiComment>)EmojiCommentRepository.findByCommentType("PRIMARY");
		List<EmojiComment> EmojiCommentsChild =(List<EmojiComment>)EmojiCommentRepository.findByCommentType("CHILD");

		
		
		if (EmojiComment.getTypeComment().equals("PRIMARY") == true) {
			System.out.println("PRIMARY");
			if (EmojiCommentsPrimary.isEmpty()) {
				return EmojiCommentRepository.save(EmojiComment);
			}
			else {
				for(EmojiComment emj:EmojiCommentsPrimary){
					
					// SAME REACT == delete previous react
					if (emj.getUser().getId() == EmojiComment.getUser().getId() && emj.getComment().getId() == EmojiComment.getComment().getId()
							&& emj.getName().equals(EmojiComment.getName()) == true){
						System.out.println("FOUND");
						EmojiCommentRepository.deleteById(emj.getId());
						return null;
					}
					// update react
					else if (emj.getUser().getId() == EmojiComment.getUser().getId() && emj.getComment().getId() == EmojiComment.getComment().getId()
							&& emj.getName().equals(EmojiComment.getName()) == false) {
					
						emj.setName(EmojiComment.getName());
						return EmojiCommentRepository.save(emj);
					}
				}
			}
		
		}
		///////////////
			else if (EmojiComment.getTypeComment().equals("CHILD") == true) {
				System.out.println("CHILD");
				
				if (EmojiCommentsChild.isEmpty()) {
					return EmojiCommentRepository.save(EmojiComment);
				}
				else {
					for(EmojiComment emj:EmojiCommentsChild){
						
						// SAME REACT == delete previous react
						if (emj.getUser().getId() == EmojiComment.getUser().getId() && emj.getChildComment().getId() == EmojiComment.getChildComment().getId()
								&& emj.getName().equals(EmojiComment.getName()) == true){
							System.out.println("FOUND");
							EmojiCommentRepository.deleteById(emj.getId());
							return null;
						}
						// update react
						else if (emj.getUser().getId() == EmojiComment.getUser().getId() && emj.getChildComment().getId() == EmojiComment.getChildComment().getId()
								&& emj.getName().equals(EmojiComment.getName()) == false) {
						
							emj.setName(EmojiComment.getName());
							return EmojiCommentRepository.save(emj);
						}
					}
				}

			}
			else {
				System.out.println("ELSE EMOJI COMMENT DETECTED");
				return null;
			}
		return EmojiCommentRepository.save(EmojiComment);
	}

	@Override
	public EmojiComment updateEmojiComment(EmojiComment a) {
		// TODO Auto-generated method stub
		return EmojiCommentRepository.save(a);
	}

	@Override
	public void deleteEmojiCommentById(Long idEmojiComment) {
		 EmojiCommentRepository.deleteById(idEmojiComment);
	}

	@Override
	public EmojiComment retrieveEmojiComment(Long idEmojiComment) {
		// TODO Auto-generated method stub
		EmojiComment EmojiComment = EmojiCommentRepository.findById(idEmojiComment).orElse(null);
		return EmojiComment;
	}

	

}
