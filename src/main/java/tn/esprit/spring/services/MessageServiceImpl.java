package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Message;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.MessageRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
@Slf4j 
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	MessageRepository MessageRepository;
	UserRepository userRepository;

	@Override
	public List<Message> retrieveAllMessages() {
		List<Message> Messages =(List<Message>)MessageRepository.findAll();
		for(Message Message:Messages){
			log.info("Message:"+Message);
		}
		
		return Messages;
	}

	@Override
	public Message sendMessage(Message Message) {
		return MessageRepository.save(Message);
	}


	@Override
	public void deleteMessageById(Long idMessage) {
		 MessageRepository.deleteById(idMessage);
	}

	@Override
	public Message retrieveMessage(Long idMessage) {
		// TODO Auto-generated method stub
		Message Message = MessageRepository.findById(idMessage).orElse(null);
		return Message;
	}


	
	
	
	

}
