package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Emoji;



public interface IEmojiService {
	
	List<Emoji> retrieveAllEmojis();
	Emoji addEmoji(Emoji e);
	Emoji updateEmoji(Emoji e);
	void deleteEmojiById(Long idEmoji);
	public Emoji retrieveEmoji(Long idEmoji);
}
