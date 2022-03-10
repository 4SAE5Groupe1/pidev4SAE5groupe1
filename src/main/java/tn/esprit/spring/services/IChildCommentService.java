package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.ChildComment;



public interface IChildCommentService {
	
	List<ChildComment> retrieveAllChildComments();
	ChildComment addChildComment(ChildComment ChildComment);
	ChildComment updateChildComment(ChildComment a);
	void deleteChildCommentById(Long idChildComment);
	public ChildComment retrieveChildComment(Long idChildComment);
}
