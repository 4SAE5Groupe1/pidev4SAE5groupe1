package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Comment;



public interface ICommentService {
	
	List<Comment> retrieveAllComments();
	Comment addComment(Comment Comment);
	Comment updateComment(Comment a);
	void deleteCommentById(Long idComment);
	public Comment retrieveComment(Long idComment);
}
