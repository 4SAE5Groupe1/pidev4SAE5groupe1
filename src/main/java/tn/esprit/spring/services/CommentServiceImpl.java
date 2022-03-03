package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Comment;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.CommentRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class CommentServiceImpl implements ICommentService{
	
	@Autowired
	CommentRepository CommentRepository;
	UserRepository userRepository;

	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> Comments =(List<Comment>)CommentRepository.findAll();
		for(Comment Comment:Comments){
			log.info("Comment:"+Comment);
		}
		
		return Comments;
	}

	@Override
	public Comment addComment(Comment Comment) {
		return CommentRepository.save(Comment);
	}

	@Override
	public Comment updateComment(Comment a) {
		// TODO Auto-generated method stub
		return CommentRepository.save(a);
	}

	@Override
	public void deleteCommentById(Long idComment) {
		 CommentRepository.deleteById(idComment);
	}

	@Override
	public Comment retrieveComment(Long idComment) {
		// TODO Auto-generated method stub
		Comment Comment = CommentRepository.findById(idComment).orElse(null);
		return Comment;
	}


	
	
	
	

}
