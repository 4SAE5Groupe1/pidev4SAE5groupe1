package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.esprit.spring.services.IServiceComplaint;

@RestController
public class ComplaintRestController {

	@Autowired
	IServiceComplaint complaintService;
	
	@PostMapping("/addComplaint")
	@ResponseBody
	public void addComplaint(@RequestBody Complaint complaint){
		complaintService.addComplaint(complaint);
	}
	
	@GetMapping("/getComplaints")
	@ResponseBody
	public List<Complaint> getAllComplaints (){
		 return complaintService.getAllComplaints();
		 }
	
	@DeleteMapping("/deleteComplaint/{idComplaint}")
	@ResponseBody
	
	public void removeStock(@RequestBody Complaint c) {
		
		complaintService.deleteComplaint(c.getIdComplaint());
	}
	
	@PutMapping("/modifyComplaint/{idComplaint}")
	@ResponseBody
	public Complaint modifyComplaint(@RequestBody Complaint c) {
	return complaintService.updateComplaint(c);
	}
	
}
