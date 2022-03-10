package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.EmojiComment;



public interface IEmojiCommentService {
	
	List<EmojiComment> retrieveAllEmojisComment();
	EmojiComment addEmojiComment(EmojiComment e);
	EmojiComment updateEmojiComment(EmojiComment e);
	void deleteEmojiCommentById(Long idEmojiComment);
	public EmojiComment retrieveEmojiComment(Long idEmojiComment);
}
