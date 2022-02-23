package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.services.IServiceAppointment;

@RestController
public class AppointmentRestController {

	@Autowired
	IServiceAppointment appointmentService;
	
	@PostMapping("/addAppointment")
	@ResponseBody
	public void addAppointment(@RequestBody Appointment appointment){
		appointmentService.addAppointment(appointment);
	}
	
	@GetMapping("/getAppointments")
	@ResponseBody
	public List<Appointment> getAllAppointments (){
		 return appointmentService.getAllAppointments();
		 }
	
	@DeleteMapping("/deleteAppointment/{idAppointment}")
	@ResponseBody
	
	public void removeAppointment(@RequestBody Appointment a) {
		
		appointmentService.deleteAppointment(a.getIdAppointment());
	}
	
	@PutMapping("/modifyComplaint/{idComplaint}")
	@ResponseBody
	public Appointment modifyAppointment(@RequestBody Appointment a) {
	return appointmentService.updateAppointment(a);
	}
	
	
}
