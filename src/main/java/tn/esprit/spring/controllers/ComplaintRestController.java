package tn.esprit.spring.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entites.Complaint;
import tn.esprit.spring.entites.GeneratePdf;
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
		 decisionComplaint="Pas de decision";
		 //decisionComplaint="Traité";
		 //decisionComplaint="En cours";
		 return complaintService.FilterDecision(decisionComplaint);
		 }
	
	@GetMapping("/report")
	@ResponseBody
	public ResponseEntity<InputStreamResource> Report() throws IOException{
		
        List<Complaint> list = complaintService.getAllComplaints();

        ByteArrayInputStream bis = null;
		try {
			bis = GeneratePdf.Report(list);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=reclamations.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
