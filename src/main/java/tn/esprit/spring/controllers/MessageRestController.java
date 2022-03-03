package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.Message;
import tn.esprit.spring.services.IMessageService;

@RestController
public class MessageRestController {
	

	@Autowired
	IMessageService MessageService; // interface
	
	@GetMapping("/retrieveAllMessages")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveAllMessages
	public List<Message> getMessages(){
		List<Message> list =  MessageService.retrieveAllMessages();
		return list;
	}
	

	@GetMapping("/retrieveMessage/{Message-id}")
	@ResponseBody
	//http://localhost:8089/SpringMVC/retrieveMessage/{Message-id}
	public Message retrieveMessage(@PathVariable("Message-id") Long MessageId){
		Message c =  MessageService.retrieveMessage(MessageId);
		return c;
	}
	
	
	@PostMapping("/sendMessage")
	@ResponseBody
	//http://localhost:8089/SpringMVC/sendMessage
	public Message addMessage (@RequestBody Message newMessage) {
		return MessageService.sendMessage(newMessage);
		
	}

	//http://localhost:8089/SpringMVC/deleteMessage/{Message-id}
	@DeleteMapping("/deleteMessage/{Message-id}")
	@ResponseBody
	public void deleteMessage (@PathVariable("Message-id") Long MessageId) {
		MessageService.deleteMessageById(MessageId);
	}
	
	
	
}
