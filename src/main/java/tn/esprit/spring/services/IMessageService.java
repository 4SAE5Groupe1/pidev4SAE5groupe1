package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entites.Message;



public interface IMessageService {
	
	List<Message> retrieveAllMessages();
	Message sendMessage(Message Message);
	void deleteMessageById(Long idMessage);
	public Message retrieveMessage(Long idMessage);
}
