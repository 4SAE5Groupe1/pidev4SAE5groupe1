package tn.esprit.spring.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.Offer;
import tn.esprit.spring.services.IServiceComplaint;

@RestController
public class ComplaintRestController {

	@Autowired
	IServiceComplaint complaintService;
	
	@PostMapping("/addComplaint/{idUser}")
	@ResponseBody
	public void addComplaint(@RequestBody Complaint complaint,@PathVariable("idUser") Long idUser){
		complaintService.addComplaint(complaint,idUser);
	}
	
	@GetMapping("/getComplaints")
	@ResponseBody
	public List<Complaint> getAllComplaints (){
		 return complaintService.getAllComplaints();
		 }
	
	@DeleteMapping("/deleteComplaint")
	@ResponseBody
	
	public void removeComplaint(@RequestBody Complaint c) {
		
		complaintService.deleteComplaint(c.getIdComplaint());
	}
	
	@PutMapping("/modifyComplaint/{idComplaint}")
	@ResponseBody
	public Complaint modifyComplaint(@RequestBody Complaint c) {
	return complaintService.updateComplaint(c);
	}
	
	@GetMapping("/filterComplaints")
	@ResponseBody
	public List<Complaint> FilterComplaintsByComplaint (String decisionComplaint){
		 //decisionComplaint="Pas de decision";
		 //decisionComplaint="Traité";
		 decisionComplaint="En cours";
		 return complaintService.FilterDecision(decisionComplaint);
		 }
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Message register(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public Message sendMessage(@Payload Message chatMessage) {
		return chatMessage;
	}
}
